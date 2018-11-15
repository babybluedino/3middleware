import { Component, OnInit } from '@angular/core';
import { Ticket } from '../../model/ticket';
import { ActivatedRoute, Router } from '@angular/router';
import { SerService } from '../../service/ser.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  ticket:Ticket
  constructor(private ar:ActivatedRoute,private ts:SerService,private router:Router)
   {

   }

  ngOnInit() 
  {
    this.ar.params.subscribe(params=>
      {
        let tid=params['id'];
        if(tid)
        {
          this.ts.getById(tid).subscribe(data=>this.ticket=data)
        }
      }
    );
  }
  delete(confirm:boolean)
  {
    if(confirm)
    {
      this.ts.delete(this.ticket.id).subscribe(resp=>
        {
          if(resp.ok)
          {
            this.router.navigateByUrl("/?opt=d&id="+this.ticket.id);
          }
        }
      );
    }
    else
    {
      this.router.navigateByUrl("/");
    }
  }

}
