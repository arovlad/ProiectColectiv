import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { EmployeesComponent } from './employees/employees.component';
import { CrudTechnologyAreaComponent } from './admin/crud-technology-area/crud-technology-area.component';
import { AddskillComponent } from './employee/addskill/addskill.component';
import { CreateProjectComponent } from './employee/create-project/create-project.component';
import { EmployeeComponent } from './employee/employee.component';
import { AddSkillsComponent } from './admin/add-skills/add-skills.component';
import { RegionsComponent } from './admin/regions/regions.component';

const routes: Routes = [
  { path: 'dashboard/admin', component: AdminComponent },
  { path: 'dashboard/employees', component: EmployeesComponent },
  { path: 'dashboard/employee/addskill', component: AddskillComponent },
  { path: 'dashboard/admin/CrudTechnologyArea', component: CrudTechnologyAreaComponent },
  { path: 'dashboard/create-project', component: CreateProjectComponent },
  { path: 'dashboard/employee/:id', component: EmployeeComponent },
  { path: 'dashboard/admin/add-skills', component: AddSkillsComponent },
  { path: 'dashboard/employee/addskill', component: AddskillComponent },
  { path: 'dashboard/admin/regions', component: RegionsComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
