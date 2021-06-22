import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { DispatcherInfoComponent } from './dispatcher-info/dispatcher-info.component';
import { CallInfoComponent } from './call-info/call-info.component';
import { CallsListComponent } from './calls-list/calls-list.component';
import { NewCallComponent } from './new-call/new-call.component';
import { CrewInfoComponent } from './crew-info/crew-info.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CallReportComponent } from './call-report/call-report.component';
import { CrewCallsListComponent } from './crew-calls-list/crew-calls-list.component';
import { RegisterCrewComponent } from './register-crew/register-crew.component';
import { RegisterDispatcherComponent } from './register-dispatcher/register-dispatcher.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    DispatcherInfoComponent,
    CallInfoComponent,
    CallsListComponent,
    NewCallComponent,
    CrewInfoComponent,
    NavbarComponent,
    CallReportComponent,
    CrewCallsListComponent,
    RegisterCrewComponent,
    RegisterDispatcherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
