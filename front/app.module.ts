import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserListComponent } from './pages/user/user-list/user-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UpdateUserComponent } from './pages/user/update-user/update-user.component';
import { CreateUserComponent } from './pages/user/create-user/create-user.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { NavbarFrontComponent } from './components/navbar-front/navbar-front.component';
import { ProfileFrontComponent } from './pages/profile-front/profile-front.component';
import { CreateDemComponent } from './pages/demande/create-dem/create-dem.component';
import { ListDemClientComponent } from './pages/demande/list-dem-client/list-dem-client.component';
import { UpdateDmComponent } from './pages/demande/update-dm/update-dm.component';
import { ListAlldemComponent } from './pages/demande/list-alldem/list-alldem.component';
import { CreateDossierComponent } from './pages/dossier/create-dossier/create-dossier.component';
import { ListDossierComponent } from './pages/dossier/list-dossier/list-dossier.component';
import { ListAgentdossierComponent } from './pages/dossier/list-agentdossier/list-agentdossier.component';
import { UpdateDossierComponent } from './pages/dossier/update-dossier/update-dossier.component';
import { PointageComponent } from './pages/pointage/pointage.component';
import { HistoriqueComponent } from './pages/historique/historique.component';
import { SearchFilterPipe } from './search-filter.pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    SidebarComponent,
    NavbarComponent,
    UpdateUserComponent,
    CreateUserComponent,
    SignupComponent,
    LoginComponent,
    ProfileComponent,
    NavbarFrontComponent,
    ProfileFrontComponent,
    CreateDemComponent,
    ListDemClientComponent,
    UpdateDmComponent,
    ListAlldemComponent,
    CreateDossierComponent,
    ListDossierComponent,
    ListAgentdossierComponent,
    UpdateDossierComponent,
    PointageComponent,
    HistoriqueComponent,
    SearchFilterPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    Ng2SearchPipeModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
