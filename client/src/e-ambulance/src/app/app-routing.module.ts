import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CallInfoComponent} from './call-info/call-info.component';
import {CallsListComponent} from './calls-list/calls-list.component';
import {DispatcherInfoComponent} from './dispatcher-info/dispatcher-info.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {NewCallComponent} from './new-call/new-call.component';


const routes: Routes = [
  {path: 'call-info', component: CallInfoComponent},
  {path: 'calls-list', component: CallsListComponent},
  {path: 'new-call', component: NewCallComponent},
  {path: 'dispatcher-info', component: DispatcherInfoComponent},
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
