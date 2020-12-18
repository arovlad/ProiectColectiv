import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
// import {ProjectsService} from '../../../services/projects.service';
import {IProfileInfo} from './profileInfo';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-my-profile',
  templateUrl: './my-profile.component.html',
  styleUrls: ['./my-profile.component.css']
})
export class MyProfileComponent implements OnInit {
  id="";
  idUser=0;
  public list: IProfileInfo[] = [
  {userId: 'userID',  firstName: 'firstName',  lastName: 'lastName',  consultingLevel: 'consultingLevel',  verified: 'verified',  region: 'region' }];
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    // @ts-ignore
    this.id = this.route.snapshot.paramMap.get('id');
      alert(this.id); // Print the parameter to the console.
    // @ts-ignore
    this.idUser = +localStorage.getItem('id');
  }

}
