import { Component, OnInit } from '@angular/core';
import {UsersInfo} from './usersInfo';
import {HttpClient} from '@angular/common/http';
import {UsersService} from '../../services/users.service';
import {FilterbytechnologyService} from '../../services/filterbytechnology.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  // searchText = '';
  public list: UsersInfo[] = [
    {id: 1, firstName: 'Diana', lastName: 'Balogh'},
    {id: 2, firstName: 'Lidia', lastName: 'Bartha'}
  ];
  query = '';
  constructor(private service: UsersService, private http: HttpClient, private FilterService: FilterbytechnologyService) { }

  ngOnInit(): void {
    this.service.get().subscribe(response =>
      {
        this.list = response;
      },
      error => {
        alert('There was an error retrieving the users.');
      });
  }

  filter(): void {
    this.FilterService.get(this.query).subscribe(response =>
    {
      this.list = response;
    });
  }
}
