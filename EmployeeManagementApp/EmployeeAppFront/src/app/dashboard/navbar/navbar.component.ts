import { Component, OnInit } from '@angular/core';
import {ILoginInformation} from '../../auth/login/loginInformation';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isVisible = false;
  var = '1';
  constructor() { }

  ngOnInit(): void {
  }

}
