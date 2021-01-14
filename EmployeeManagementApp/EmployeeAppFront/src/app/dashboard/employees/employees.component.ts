import { Component, OnInit } from '@angular/core';
import {IEmployeeInfo} from '../employee/employeeInfo';
import {HttpClient} from '@angular/common/http';
import {UsersService} from '../../services/users.service';
import {FilterbytechnologyService} from '../../services/filterbytechnology.service';
import {SkillService} from '../../services/skill.service';

@Component({
  selector: 'app-users',
  templateUrl: './employees.component.html'
})
export class EmployeesComponent implements OnInit {
  // searchText = '';
  public list: IEmployeeInfo[] = [];
  query = '';
  techArea = '';
  picture = 'assets/profile.png ';
  // tslint:disable-next-line:max-line-length
  constructor(private service: UsersService, private http: HttpClient, private FilterService: FilterbytechnologyService, private skillService: SkillService) { }

  ngOnInit(): void {
    this.getAllTechAreas2();
    this.service.get().subscribe(response =>
      {
        this.list = response;
      },
      error => {
        alert('There was an error retrieving the users.');
      });
  }
  getAllTechAreas2(): void {
    this.skillService.getAllTechAreas().subscribe(
      (dataaa) => {

        this.techArea = dataaa;
        console.log(this.techArea);

      },
      (error) => {

        console.log('error');
      }
    );
  }

  filter(): void {
    this.FilterService.get(this.query).subscribe(response =>
    {
      this.list = response.profileList;
    });
  }
}
