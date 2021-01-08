import { Component, OnInit } from '@angular/core';
import {IEmployeeInfo} from '../employee/employeeInfo';
import {HttpClient} from '@angular/common/http';
import {UsersService} from '../../services/users.service';
import {FilterbytechnologyService} from '../../services/filterbytechnology.service';

@Component({
  selector: 'app-users',
  templateUrl: './employees.component.html'
})
export class EmployeesComponent implements OnInit {
  // searchText = '';
  public list: IEmployeeInfo[] = [];
  query = '';
  constructor(private service: UsersService, private http: HttpClient, private FilterService: FilterbytechnologyService) { }

  ngOnInit(): void {
    this.service.get().subscribe(response =>
      {
        this.list = response;
      },
      error => {
        alert('There was an error retrieving the users.');
      });
  }

  filter(): void {
    this.FilterService.get(this.query).subscribe(response =>
    {
      this.list = response.profileList;
    });
  }
}