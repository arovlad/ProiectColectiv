import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { UsersComponent } from './users/users.component';
import { ProjectsComponent } from './projects/projects.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { AddskillComponent } from './user/addskill/addskill.component';
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [UsersComponent, ProjectsComponent, AdminComponent, UserComponent, AddskillComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule
  ],
  exports: [
    UsersComponent,
    ProjectsComponent,
    AdminComponent
  ]
})
export class DashboardModule { }
