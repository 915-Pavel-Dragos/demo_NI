import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Game, GameService } from '../../game.service';


@Component({
  selector: 'app-game-form',
  imports: [ReactiveFormsModule],
  templateUrl: './game-form.component.html',
  styleUrl: './game-form.component.scss'
})
export class GameFormComponent implements OnInit {
  game: Game[] = [];
  gameForm!: FormGroup;
  isEditMode = false;
  gameId!: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private gameService: GameService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.gameForm = this.fb.group({
      name: ['', Validators.required],
      date_published: ['', Validators.required],
      copies_sold: [0, [Validators.required, Validators.min(0)]],
      no_achivements: [0, [Validators.required, Validators.min(0)]]
    });

    this.route.params.subscribe(params => {
      if (params['id']) {
        this.isEditMode = true;
        this.gameId = +params['id'];
        this.gameService.getGameById(this.gameId).subscribe(game => {
          this.gameForm.patchValue(game);
        });
      }
    });
  }

  onSubmit(): void {
    if (this.isEditMode) {
      this.gameService.updateGame(this.gameId, this.gameForm.value).subscribe(() => {
        this.router.navigate(['/games']);
      });
    } else {
      this.gameService.addGame(this.gameForm.value).subscribe(() => {
        this.router.navigate(['/games']);
      });
    }
  }
} 
