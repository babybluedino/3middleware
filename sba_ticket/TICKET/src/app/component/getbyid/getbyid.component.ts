import { Component, OnInit } from '@angular/core';
import { SerService } from '../../service/ser.service';
import { ActivatedRoute } from '@angular/router';
import { Ticket } from '../../model/ticket';

@Component({
  selector: 'app-getbyid',
  templateUrl: './getbyid.component.html',
  styleUrls: ['./getbyid.component.css']
})
export class GetbyidComponent implements OnInit {

  tickets:Ticket;
  constructor(private ts:SerService,private ar:ActivatedRoute)
   {

   }

  ngOnInit()
   {
    this.tickets=new Ticket();
      this.ar.params.subscribe(params=>
       {
          let tid=params['id'];
          this.ts.getById(tid).subscribe(data=>
            {this.tickets=data})
       }
      )
   }

}
