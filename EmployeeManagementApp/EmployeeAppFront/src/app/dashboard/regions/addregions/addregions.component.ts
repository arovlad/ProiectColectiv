import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addregions',
  templateUrl: './addregions.component.html',
  styleUrls: ['./addregions.component.css']
})
export class AddregionsComponent implements OnInit {
  regionname = '';

  constructor() { }

  ngOnInit(): void {
  }

}
