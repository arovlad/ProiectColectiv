import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IProjectInfo } from './projectInfo';
import {ProjectsService} from '../../../services/projects.service';

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html'
})
export class ProjectsComponent implements OnInit {
  public list: IProjectInfo[] = [
    {title: 'Project #1', role: 'Team leader', description: 'I worked on this.'},
    {title: 'Project #2', role: 'Consultant', description: 'I worked on this too.'}
  ];

  constructor(private service: ProjectsService, private http: HttpClient) { }

  ngOnInit(): void {
    this.service.get().subscribe(response =>
    {
      this.list = response;
    },
    error => {
      alert('There was an error retrieving the projects.');
    });
  }

}
