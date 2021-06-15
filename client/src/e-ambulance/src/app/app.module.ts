import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DispatcherNavbarComponent } from './dispatcher-navbar/dispatcher-navbar.component';
import { DispatcherInfoComponent } from './dispatcher-info/dispatcher-info.component';
import { CallInfoComponent } from './call-info/call-info.component';
import { CallsListComponent } from './calls-list/calls-list.component';
import { NewCallComponent } from './new-call/new-call.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    DispatcherNavbarComponent,
    DispatcherInfoComponent,
    CallInfoComponent,
    CallsListComponent,
    NewCallComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
