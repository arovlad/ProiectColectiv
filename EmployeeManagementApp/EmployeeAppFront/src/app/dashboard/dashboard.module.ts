import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { EmployeesComponent } from './employees/employees.component';
import { AdminComponent } from './admin/admin.component';
import { AddskillComponent } from './employee/addskill/addskill.component';
import { FormsModule } from '@angular/forms';
import { DashboardNavbarComponent } from './dashboard-navbar.component';
import { CreateProjectComponent } from './employee/create-project/create-project.component';
import { ProjectsComponent } from './employee/projects/projects.component';
import { EmployeeComponent } from './employee/employee.component';
import { AddSkillsComponent } from './admin/add-skills/add-skills.component';
import { RegionsComponent } from './admin/regions/regions.component';
import { CrudTechnologyAreaComponent } from './admin/crud-technology-area/crud-technology-area.component';


@NgModule({

  declarations: [EmployeesComponent, AdminComponent, DashboardNavbarComponent, CreateProjectComponent,
    ProjectsComponent, EmployeeComponent, AddskillComponent, AddSkillsComponent, RegionsComponent, CrudTechnologyAreaComponent],

  imports: [
    CommonModule,
    DashboardRoutingModule,
    FormsModule
  ],
  exports: [
    EmployeesComponent,
    ProjectsComponent,
    AdminComponent,
    DashboardNavbarComponent,
    CreateProjectComponent,
    AddSkillsComponent
  ]
})
export class DashboardModule {}
