import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Game {
  id?: number;
  name: string;
  date_published: string;
  copies_sold: number;
  no_achivements: number;
  user_id?: number;
}


@Injectable({
  providedIn: 'root'
})
export class GameService {
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAllGames(): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.baseUrl}/api/games`);
  }

  getMyGames(): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.baseUrl}/users/mygames`);
  }

  getGameById(id: number): Observable<Game> {
    return this.http.get<Game>(`${this.baseUrl}/api/games/${id}`);
  }

  addGame(game: Game):Observable<Game> {
    return this.http.post<Game>(`${this.baseUrl}/api/games`, game);
  }

  updateGame(id: number, game: Game): Observable<Game> {
    return this.http.put<Game>(`${this.baseUrl}/api/games/${id}`, game);
  }

  deleteGame(id: number):Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/api/games/${id}`);
  }

}
