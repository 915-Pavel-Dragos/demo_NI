import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GameService } from '../../game.service';
import { Game } from '../../game.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-game-detail',
  imports: [CommonModule],
  templateUrl: './game-detail.component.html',
  styleUrl: './game-detail.component.scss'
})
export class GameDetailComponent implements OnInit {
  game: Game | null = null;

  constructor(
    private route: ActivatedRoute,
    private gameService: GameService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      
      if (id) {
        this.gameService.getGameById(+id).subscribe((game) => {
          this.game = game;
          console.log("This is game: ", this.game);
        });
      }
    });
  }
}
