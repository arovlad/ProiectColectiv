import { Component, OnInit } from '@angular/core';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './dashboard-navbar.component.html'
})
export class DashboardNavbarComponent implements OnInit {
  isVisible = false;
  title = '';
  id = '';

  constructor() { }

  ngOnInit(): void {
    // @ts-ignore
    this.id = localStorage.getItem('id');
    this.title = AppComponent.title;
    if ( localStorage.getItem('role') === '2') {
      this.isVisible = true;
    }
  }

  expand(): void {
    // @ts-ignore
    document.getElementById('NavbarDropdownMenu').style.display = 'initial';
    console.log('expand');
  }

  collapse(): void {
    // @ts-ignore
    document.getElementById('NavbarDropdownMenu').style.display = 'none';
  }
}
