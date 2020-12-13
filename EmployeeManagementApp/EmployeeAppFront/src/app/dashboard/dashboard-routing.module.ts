import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { ProjectsComponent } from './projects/projects.component';
import { UsersComponent } from './users/users.component';
import {AddskillComponent} from "./user/addskill/addskill.component";
import {CrudTechnologyAreaComponent} from "./admin/crud-technology-area/crud-technology-area.component";

const routes: Routes = [
  { path: 'dashboard/admin', component: AdminComponent },
  { path: 'dashboard/projects', component: ProjectsComponent },
  { path: 'dashboard/users', component: UsersComponent},
  { path: 'dashboard/user/addskill', component: AddskillComponent},
  {path:'dashboard/admin/CrudTechnologyArea',component:CrudTechnologyAreaComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
