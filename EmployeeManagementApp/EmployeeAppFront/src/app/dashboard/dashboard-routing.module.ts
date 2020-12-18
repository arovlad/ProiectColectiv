import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { EmployeesComponent } from './employees/employees.component';
import { CrudTechnologyAreaComponent } from './admin/crud-technology-area/crud-technology-area.component';
import { AddskillComponent } from './employee/addskill/addskill.component';
import { DashboardNavbarComponent } from './dashboard-navbar.component';
import { CreateProjectComponent } from './employee/create-project/create-project.component';
import { EmployeeComponent } from './employee/employee.component';
import { AddSkillsComponent } from './admin/add-skills/add-skills.component';
import { RegionsComponent } from './admin/regions/regions.component';

const routes: Routes = [
  { path: 'dashboard/admin', component: AdminComponent },
  { path: 'dashboard/users', component: EmployeesComponent },
  { path: 'dashboard/user/addskill', component: AddskillComponent },
  { path: 'dashboard/admin/CrudTechnologyArea', component: CrudTechnologyAreaComponent },
  { path: 'dashboard/navbar', component: DashboardNavbarComponent },
  { path: 'dashboard/profile', component: ProfileComponent },
  { path: 'dashboard/create-project', component: CreateProjectComponent },
  { path: 'dashboard/users', component: EmployeesComponent },
  { path: 'dashboard/my-profile/:id', component: EmployeeComponent },
  { path: 'dashboard/add-skills', component: AddSkillsComponent },
  { path: 'dashboard/user/addskill', component: AddskillComponent },
  { path: 'dashboard/admin/regions', component: RegionsComponent }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
