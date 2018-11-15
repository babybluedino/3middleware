import { Component, OnInit } from '@angular/core';
import { Ticket } from '../../model/ticket';
import { SerService } from '../../service/ser.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-getall',
  templateUrl: './getall.component.html',
  styleUrls: ['./getall.component.css']
})
export class GetallComponent implements OnInit {

  tickets:Ticket[];
  constructor(private ts:SerService,private ar:ActivatedRoute) 
  {

  }

  ngOnInit() 
  {
    this.ar.queryParams.subscribe(params=>
      {
        let field=params['field'];
        let srchValue=params['srchValue'];
        if(field && srchValue)
        {
          this.ts.searchTicket(field,srchValue).subscribe(data=>
            this.tickets=data);
        }
        else
        {
          this.ts.getAll().subscribe(data=>this.tickets=data);
        }
      }

    )
    
  }

}
