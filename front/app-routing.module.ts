import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavbarFrontComponent } from './components/navbar-front/navbar-front.component';
import { CreateDemComponent } from './pages/demande/create-dem/create-dem.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileFrontComponent } from './pages/profile-front/profile-front.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { CreateUserComponent } from './pages/user/create-user/create-user.component';
import { UpdateUserComponent } from './pages/user/update-user/update-user.component';
import { UserListComponent } from './pages/user/user-list/user-list.component';
import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { TokenStorageService } from './services/token-storage.service';
import { ListDemClientComponent } from './pages/demande/list-dem-client/list-dem-client.component';
import { UpdateDmComponent } from './pages/demande/update-dm/update-dm.component';
import { ListAlldemComponent } from './pages/demande/list-alldem/list-alldem.component';
import { CreateDossierComponent } from './pages/dossier/create-dossier/create-dossier.component';
import { ListAgentdossierComponent } from './pages/dossier/list-agentdossier/list-agentdossier.component';
import { UpdateDossierComponent } from './pages/dossier/update-dossier/update-dossier.component';
import { ListDossierComponent } from './pages/dossier/list-dossier/list-dossier.component';
import { PointageComponent } from './pages/pointage/pointage.component';
import { HistoriqueComponent } from './pages/historique/historique.component';
 
@Injectable({ providedIn: 'root'})
export class AuthGuardService implements CanActivate {

  constructor(private tokenStorage: TokenStorageService, private router: Router) {}
  
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.tokenStorage.getToken() != null) {
      return true;
    } else {
      this.router.navigate(['login']);
      return false;
    }
  }
}

const routes: Routes = [
 
   {path: '', redirectTo: 'login', pathMatch: 'full'},
  {path: 'signup', component: SignupComponent},
  { path: 'login', component: LoginComponent},

   {path: 'user', component: UserListComponent, canActivate: [AuthGuardService] },
  {path: 'user/create', component: CreateUserComponent},
  {path: 'adminprofile', component: ProfileComponent},
  {path: 'user/update/:id', component: UpdateUserComponent},
  {path: 'demandeClient/update/:id', component: UpdateDmComponent},
    {path: 'profile', component: ProfileFrontComponent},
  {path: 'nav', component: NavbarFrontComponent},

  {path: 'demande/add', component: CreateDemComponent},
  {path: 'demandeClient', component: ListDemClientComponent},
  {path: 'demande/all', component: ListAlldemComponent},
  
  {path: 'dossier/add', component: CreateDossierComponent},
  {path: 'dossier/agentAll', component: ListAgentdossierComponent},
  {path: 'dossier/update/:id', component: UpdateDossierComponent},
  {path: 'dossier/all', component: ListDossierComponent},

  {path: 'pointage', component: PointageComponent},

  {path: 'historique', component: HistoriqueComponent},
 
 

 // {path: 'employee-details/:id', component: EmployeeDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
