import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit {

  projectName = '';
  customerName = '';
  industry = '';
  roleName = '';
  start = '';
  end = '';
  description = '';
// trebe getAllIndustries si getAllRoles
  constructor() { }

  ngOnInit(): void {
  }

}
