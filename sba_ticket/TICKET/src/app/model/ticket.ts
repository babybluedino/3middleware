import { Time, DatePipe } from "@angular/common";
export class Ticket 
{
    id:number;
    raisedBy:string;
    createdDate:DatePipe;
    assignedTo:string;
    subject:string;
    description:string;
    currentState:string;

}
