import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { UsersComponent } from './users/users.component';
import { AdminComponent } from './admin/admin.component';
import { ProjectsComponent } from './users/projects/projects.component';

@NgModule({
  declarations: [UsersComponent, AdminComponent, ProjectsComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ],
  exports: [
    UsersComponent,
    AdminComponent
  ]
})
export class DashboardModule { }
