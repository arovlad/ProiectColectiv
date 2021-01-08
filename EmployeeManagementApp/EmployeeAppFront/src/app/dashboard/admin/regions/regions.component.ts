import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {RegionsService} from '../../../services/regions.service';

@Component({
  selector: 'app-regions',
  templateUrl: './regions.component.html'
})
export class RegionsComponent implements OnInit {
  regions: Array<any> = [];
  name = '';
  newName = '';
  constructor(private regionsService: RegionsService, private router: Router) { }

  ngOnInit(): void {
  }
  delete(param: string): void{
    this.name = param;
    alert(this.name);
    this.regionsService.delete(this.name).subscribe((data) => {
      alert('region area deleted from database');
    }, (error) => {
      alert('something went wrong');
    });
  }
  insert(): void {
    alert(this.newName);
    this.regionsService.save(this.newName).subscribe((data) => {
      alert('region saved in database');
    }, (error) => {
      alert('something went worng');
    });


  }

}
