import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import {ProjectsService} from '../../../services/projects.service';
import {ActivatedRoute} from '@angular/router';
import {IEmployeeInfo} from './employeeInfo';

@Component({
  selector: 'app-my-profile',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent implements OnInit {
  id = '';
  idUser = 0;
  public list: IEmployeeInfo[] = [];
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    // @ts-ignore
    this.id = this.route.snapshot.paramMap.get('id');
    alert(this.id);
    // @ts-ignore
    this.idUser = +localStorage.getItem('id');
  }

}
