import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { UsersComponent } from './users/users.component';
import {NavbarComponent} from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import {MyProfileComponent} from './my-profile/my-profile.component';
import {AddSkillsComponent} from './add-skills/add-skills.component';

const routes: Routes = [
  { path: 'dashboard/admin', component: AdminComponent },
  { path: 'dashboard/users', component: UsersComponent},
  { path: 'dashboard/navbar', component: NavbarComponent},
  {path: 'dashboard/profile', component: ProfileComponent},
  { path: 'dashboard/create-project', component: CreateProjectComponent},
  { path: 'dashboard/users', component: UsersComponent},
  { path: 'dashboard/my-profile', component: MyProfileComponent},
  {path: 'dashboard/add-skills', component: AddSkillsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
