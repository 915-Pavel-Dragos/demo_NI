import { Component, OnInit } from '@angular/core';
import { Game, GameService } from '../../game.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../../auth/auth.service';


@Component({
  selector: 'app-my-games',
  imports: [CommonModule, RouterModule],
  templateUrl: './my-games.component.html',
  styleUrl: './my-games.component.scss'
})
export class MyGamesComponent implements OnInit {
  games: Game[] = [];

  constructor(private gameService: GameService, private auth: AuthService) {}

  ngOnInit(): void {
    this.gameService.getMyGames().subscribe((games) => this.games = games);
    console.log("this is my games", this.games);
  }

  deleteGame(id: number): void {
    this.gameService.deleteGame(id).subscribe(() => {
      this.games = this.games.filter(game => game.id !== id);
    });
  } 

  logout(): void {
    this.auth.logout();
  }
}
