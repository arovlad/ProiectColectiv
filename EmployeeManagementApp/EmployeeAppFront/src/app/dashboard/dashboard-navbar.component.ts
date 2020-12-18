import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './dashboard-navbar.component.html'
})
export class DashboardNavbarComponent implements OnInit {
  isVisible = false;

  constructor() { }

  ngOnInit(): void {
    if ( localStorage.getItem('role') === '2') {
      this.isVisible = true;
    }
  }
}
