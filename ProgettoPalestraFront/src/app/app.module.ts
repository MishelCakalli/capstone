import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './auth/login/login.component';
import { SingupComponent } from './auth/singup/singup.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { HomeComponent } from './components/home/home.component';
import { Error404Component } from './components/error404/error404.component';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SingupComponent,
    LandingPageComponent,
    HomeComponent,
    Error404Component,
    NavbarComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
