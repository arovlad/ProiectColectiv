import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';

import {FormsModule} from '@angular/forms';
import {AuthModule} from './auth/auth.module';
import {DashboardModule} from './dashboard/dashboard.module';
import {LoginService} from './services/login.service';
import {ProjectsService} from './services/projects.service';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    AuthModule,
    DashboardModule,
    HttpClientModule
  ],
  providers: [LoginService, ProjectsService],
  bootstrap: [AppComponent]
})

export class AppModule { }
