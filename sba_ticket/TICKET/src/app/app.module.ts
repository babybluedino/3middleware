import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule,Routes} from '@angular/router';

import { AppComponent } from './app.component';
import {HttpModule } from '@angular/http';
import { HomeComponent } from './component/home/home.component';
import { AddComponent } from './component/add/add.component';
import { GetallComponent } from './component/getall/getall.component';
import { GetbyidComponent } from './component/getbyid/getbyid.component';
import { DeleteComponent } from './component/delete/delete.component';

const paths : Routes =[
  {path:'',component:HomeComponent},
  {path:'listTasks',component:GetallComponent},
  //{path:'getByIdTasks',component:GetByIdTasksComponent},
  {path:'addTicket',component:AddComponent},
  {path:'updateTicket/:id',component:AddComponent},
  {path:'deleteTicket/:id',component:DeleteComponent},
  {path:'viewTicket/:id',component:GetbyidComponent}
  
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddComponent,
    GetallComponent,
    GetbyidComponent,
    DeleteComponent,
  ],
  imports: [
    BrowserModule,HttpModule,FormsModule, RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
