import { Component, OnInit } from '@angular/core';
import { SerService } from '../../service/ser.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Ticket } from '../../model/ticket';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  tickets:Ticket;
  isUpdate:boolean;
  constructor(private ts:SerService,private ar:ActivatedRoute,private router:Router)
   {

   }

  ngOnInit() 
  {
    this.tickets=new Ticket();
    this.isUpdate=false;
    this.ar.params.subscribe(params=>
      {let tid=params['id'];
       if(tid)
        {
          this.ts.getById(tid).subscribe(data=>
            {
              this.tickets=data;
              this.isUpdate=true;
            }
            )
        }
      }
    )
  }

  save()
  {
    if(this.isUpdate)
    {
      this.ts.updateTicket(this.tickets).subscribe(data=>
        {
          this.router.navigateByUrl("/?opt=a&id="+data.id);
        },
        error=>
        {
          alert("some error happened")
        })
    }
    else
    {
      this.ts.add(this.tickets).subscribe(data=>
        {
          this.router.navigateByUrl("/?opt=a&id="+data.id);
        },
        error=>
        {
          alert("some error happened");
        })
    }
  }

}
