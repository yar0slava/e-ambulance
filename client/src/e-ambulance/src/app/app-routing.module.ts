import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CallInfoComponent} from './call-info/call-info.component';
import {CallsListComponent} from './calls-list/calls-list.component';
import {DispatcherInfoComponent} from './dispatcher-info/dispatcher-info.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {NewCallComponent} from './new-call/new-call.component';
import {CrewInfoComponent} from "./crew-info/crew-info.component";
import {CallReportComponent} from "./call-report/call-report.component";
import {CrewCallsListComponent} from "./crew-calls-list/crew-calls-list.component";


const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full' },
  {path: 'call/:id', component: CallInfoComponent},
  {path: 'calls', component: CallsListComponent},
  {path: 'new-call', component: NewCallComponent},
  {path: 'call-report/:id', component: CallReportComponent},
  {path: 'crew-calls/:id', component: CrewCallsListComponent},
  {path: 'dispatcher/:id', component: DispatcherInfoComponent},
  {path: 'crew/:id', component: CrewInfoComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
