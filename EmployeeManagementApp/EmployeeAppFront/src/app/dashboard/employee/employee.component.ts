import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import {ProjectsService} from '../../../services/projects.service';
import {ActivatedRoute} from '@angular/router';
import {IEmployeeInfo} from './employeeInfo';
import {SkillService} from '../../services/skill.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent implements OnInit {
  id = 0;
  idUser = 0;
  firstName = 'John';
  consultingLevel = 'consulting level';
  lastName = 'Bon';
  picture = 'assets/profile.png ';
  verified = 0;
  equals = 0;
  region = 'Cluj-Napoca';
  skills: Array<any> = [];
  public list: IEmployeeInfo[] = [];
  name = this.firstName + ' ' + this.lastName;
  constructor(private route: ActivatedRoute, private skillService: SkillService) { }

  ngOnInit(): void {
    // @ts-ignore
    this.id = +this.route.snapshot.paramMap.get('id');
    // @ts-ignore
    this.idUser = +localStorage.getItem('id');

    if (this.id === this.idUser){
      this.equals = 1;
    }
    this.getAllTechAreas();
  }
  getAllTechAreas(): void {
    this.skillService.getAllTechAreas().subscribe(
      (dataaa) => {

        this.skills = dataaa;
        console.log(this.skills);

      },
      (error) => {

        console.log('error');
      }
    );
  }

}
