import { Component, OnInit } from '@angular/core';
import { Game, GameService } from '../../game.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../../../auth/auth.service';

@Component({
  selector: 'app-game-list',
  imports: [CommonModule, RouterModule],
  templateUrl: './game-list.component.html',
  styleUrl: './game-list.component.scss'
})
export class GameListComponent implements OnInit {
  games: Game[] = [];

  constructor(private gameService: GameService, private auth: AuthService) {}

  ngOnInit(): void { 
    this.gameService.getAllGames().subscribe((games) => this.games = games);
    console.log('This is games from getAllGames', this.gameService.getAllGames().subscribe());
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
