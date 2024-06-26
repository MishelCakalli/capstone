import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';



import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/singup/singup.component';
import { TokenInterceptor } from './auth/token.interceptor';
import { AuthService } from './auth/auth.service';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { AppuntamentoService } from './service/appuntamento.service';
import { Appuntamento } from './interfaces/appuntamento';
import { Error404Component } from './components/error404/error404.component';


const routes: Route[] = [
  {
    path: '',
    component: LandingPageComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: SignupComponent,
  },{
    path: '**',
    component: Error404Component,
},
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    LandingPageComponent,
    

    
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule, 
    HttpClientModule, 
    FormsModule, 
    RouterModule.forRoot(routes),
  ],
  providers: [
    [AppuntamentoService],
    {
      
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
      
    },
    
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }