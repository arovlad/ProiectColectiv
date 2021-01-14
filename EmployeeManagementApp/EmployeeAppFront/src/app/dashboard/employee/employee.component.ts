import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import {ProjectsService} from '../../../services/projects.service';
import {ActivatedRoute} from '@angular/router';
import {IEmployeeInfo} from './employeeInfo';
import {IProfileInfo} from './profileInfo';
import {SkillService} from '../../services/skill.service';
import {ILoginInformation} from '../../auth/login/loginInformation';
import {ProfileService} from '../../services/profile.service';

@Component({
  selector: 'app-my-profile',
  templateUrl: './employee.component.html'
})
export class EmployeeComponent implements OnInit {
  id = 0;
  idUser = 0;
  idProfile = 0;
  firstName = '';
  consultingLevel = '';
  lastName = '';
  picture = 'assets/profile.png';
  verified = 0;
  equals = 0;
  region = '';
  insertSkill = '';
  skills: Array<any> = [];
  myskills: Array<any> = [];
  public list: IEmployeeInfo[] = [];
  name = '';
  skillLevel = 0;
  idSkill = 0;
  constructor(private route: ActivatedRoute, private skillService: SkillService, private profileService: ProfileService) { }

  ngOnInit(): void {
    // @ts-ignore
    this.id = +this.route.snapshot.paramMap.get('id');
    // @ts-ignore
    this.idUser = +localStorage.getItem('id');
    if (this.id === this.idUser){
      this.equals = 1;
    }
    this.id = Number( this.id );
    this.getAllTechAreas();
    this.getAllTechAreas2();
    this.profileService.getData(this.id).subscribe(
      response => {
        const profileInfo: IProfileInfo = response;
        this.firstName = profileInfo.firstName;
        this.lastName = profileInfo.lastName;
        this.consultingLevel = profileInfo.consultingLevelName;
        this.region = profileInfo.regionName;
        this.name = this.firstName + ' ' + this.lastName;
        this.verified = profileInfo.verified;
        this.idProfile = profileInfo.idProfile;
      }, error => {
       alert('error');
      }
    );
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
  getAllTechAreas2(): void {
    this.skillService.getAllTechAreas().subscribe(
      (dataaa) => {

        this.myskills = dataaa;
        console.log(this.skills);

      },
      (error) => {

        console.log('error');
      }
    );
  }
  saveSkill(param: any , level: any): void{
    this.insertSkill = param;
    alert(this.insertSkill);
    this.skillLevel = level;
    alert(this.skillLevel);
    this.insertSkill = 'CPP';
    this.skillService.idSKill(this.insertSkill).subscribe(data => {
      this.idSkill = data;
      this.skillLevel = + this.skillLevel;
      this.skillService.saveProfileSkill(this.idProfile, this.idSkill, this.skillLevel).subscribe(dataa => {
        alert('new skill saved');
      }, error => {
        alert('error');
      });
    }, error => {
      alert('error');
    });
  }

}
