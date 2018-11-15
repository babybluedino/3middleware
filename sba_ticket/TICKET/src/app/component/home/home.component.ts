import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  picUrl:String;
  constructor(private router:Router)
   { 
     this.picUrl="/assets/banner.png"
   }

  ngOnInit() {
  }

}
