import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-regions',
  templateUrl: './regions.component.html',
  styleUrls: ['./regions.component.css']
})
export class RegionsComponent implements OnInit {
  regionname = '';
  errMessageRegionName = 0;
  constructor() { }

  ngOnInit(): void {
  }
  saveRegion(): void{
    this.errMessageRegionName = 0;
  }

}
