import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { UsersComponent } from './users/users.component';
import { AdminComponent } from './admin/admin.component';
import { UserComponent } from './user/user.component';
import { AddskillComponent } from './user/addskill/addskill.component';
import {FormsModule} from '@angular/forms';
import { NavbarComponent} from './navbar/navbar.component';
import { ProfileComponent } from './profile/profile.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import {ProjectsComponent} from './users/projects/projects.component';
import { AddregionsComponent } from './regions/addregions/addregions.component';

@NgModule({

  declarations: [UsersComponent, AdminComponent, NavbarComponent, ProfileComponent, CreateProjectComponent,
    ProjectsComponent, AddskillComponent, UserComponent, AddregionsComponent],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule
  ],
  exports: [
    UsersComponent,
    AdminComponent,
    NavbarComponent,
    ProfileComponent,
    CreateProjectComponent
  ]
})
export class DashboardModule { }
