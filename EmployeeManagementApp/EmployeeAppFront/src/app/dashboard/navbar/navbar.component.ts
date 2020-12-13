import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isVisible = false;

  constructor() { }

  ngOnInit(): void {
    if ( localStorage.getItem('role') === '2') {
      this.isVisible = true;
    }
  }
}
