import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { GameListComponent } from './games/game-list/game-list/game-list.component';
import { GameFormComponent } from './games/game-form/game-form/game-form.component';
import { MyGamesComponent } from './games/my-games/my-games/my-games.component';
import { authGuard } from './guards/auth.guard';
import { GameDetailComponent } from './games/game-detail/game-detail/game-detail.component';


export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'signup', component: SignupComponent },
    { path: 'games', component: GameListComponent, canActivate: [authGuard] },
    { path: 'games/new', component: GameFormComponent, canActivate: [authGuard] },
    { path: 'games/edit/:id', component: GameFormComponent, canActivate: [authGuard] },
    { path: 'my-games', component: MyGamesComponent, canActivate: [authGuard] },
    { path: 'games/:id', component: GameDetailComponent, canActivate: [authGuard] },
    { path: '', redirectTo: '/games', pathMatch: 'full'}
];


