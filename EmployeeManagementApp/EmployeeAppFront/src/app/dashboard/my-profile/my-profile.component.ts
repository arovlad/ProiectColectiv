import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import {ProjectsService} from '../../../services/projects.service';
import {IProfileInfo} from './profileInfo';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  public list: IProfileInfo[] = [
  {userId: 'userID',  firstName: 'firstName',  lastName: 'lastName',  consultingLevel: 'consultingLevel',  verified: 'verified',  region: 'region' }];
  constructor() { }

  ngOnInit(): void {

  }

}
