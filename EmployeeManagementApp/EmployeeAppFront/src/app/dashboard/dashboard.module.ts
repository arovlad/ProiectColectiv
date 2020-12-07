import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { UsersComponent } from './users/users.component';
import { ProjectsComponent } from './projects/projects.component';
import { AdminComponent } from './admin/admin.component';
import { NavbarComponent} from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import {FormsModule} from '@angular/forms';

@NgModule({
  declarations: [UsersComponent, ProjectsComponent, AdminComponent, NavbarComponent, ProfileComponent, CreateProjectComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule
  ],
  exports: [
    UsersComponent,
    ProjectsComponent,
    AdminComponent,
    NavbarComponent,
    ProfileComponent,
    CreateProjectComponent
  ]
})
export class DashboardModule { }
