import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { UsersComponent } from './users/users.component';
import { ProjectsComponent } from './projects/projects.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  declarations: [UsersComponent, ProjectsComponent, AdminComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule
  ],
  exports: [
    UsersComponent,
    ProjectsComponent,
    AdminComponent
  ]
})
export class DashboardModule { }
