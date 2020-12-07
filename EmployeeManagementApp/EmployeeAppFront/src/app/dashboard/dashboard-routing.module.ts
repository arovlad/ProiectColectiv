import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { UsersComponent } from './users/users.component';
import {AddskillComponent} from "./user/addskill/addskill.component";
import {NavbarComponent} from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { CreateProjectComponent } from './create-project/create-project.component';

const routes: Routes = [
  { path: 'dashboard/admin', component: AdminComponent },
  { path: 'dashboard/users', component: UsersComponent},
  { path: 'dashboard/navbar', component: NavbarComponent},
  {path: 'dashboard/profile', component: ProfileComponent},
  { path: 'dashboard/create-project', component: CreateProjectComponent},
  { path: 'dashboard/users', component: UsersComponent},
  { path: 'dashboard/user/addskill', component: AddskillComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
