import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ticket';
  field:string="raisedBy";
  srchValue:string="";
  constructor(private router:Router)
  {

  }
  doSearch(){
    this.router.navigate(["/listTasks"],{queryParams:{field:this.field,srchValue:this.srchValue}});
  }
}
