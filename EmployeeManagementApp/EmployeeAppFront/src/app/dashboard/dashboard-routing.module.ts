import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ProjectsComponent } from './projects/projects.component';
import { UsersComponent } from './users/users.component';
import {AddskillComponent} from "./user/addskill/addskill.component";

const routes: Routes = [
  { path: 'dashboard/admin', component: AdminComponent },
  { path: 'dashboard/projects', component: ProjectsComponent },
  { path: 'dashboard/users', component: UsersComponent},
  { path: 'dashboard/user/addskill', component: AddskillComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
