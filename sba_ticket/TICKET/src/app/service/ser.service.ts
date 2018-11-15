import { Injectable } from '@angular/core';
import { Ticket } from '../model/ticket';
import {Http,RequestOptions, Headers, Response} from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SerService 
{
  baseUrl:string;

  constructor(private http:Http) 
  {
    this.baseUrl="http://localhost:6565/ticket/"
   }




   
  getBaseUrlForGetAll()
  {
    return this.baseUrl+"getall";
  }
  getAll():Observable<Ticket[]>
  {
    return this.http.get(this.getBaseUrlForGetAll()).pipe(map(data=>data.json()));
  }




  getJsonContentTypeHeader():RequestOptions
  {
    const headers=new Headers();
    headers.append('Content-Type','application/json');
    return new RequestOptions({headers:headers});
  }
  getBaseUrlForAdd():string
  {
    return this.baseUrl+"add";
  }
  add(ticket:Ticket):Observable<Ticket>
  {
    return this.http.post(this.getBaseUrlForAdd(),JSON.stringify(ticket),this.getJsonContentTypeHeader()).pipe(map(data=>data.json()));
  }




  getBaseUrlForGetById(id):string
  {
    return this.baseUrl+"get/"+id
  }
  getById(id:number):Observable<Ticket>
  {
    return this.http.get(this.getBaseUrlForGetById(id)).pipe(map(data=>data.json()));
  }




  getBaseUrlForUpdateTicket():string
  {
    return this.baseUrl+"update";
  }
  updateTicket(ticket:Ticket):Observable<Ticket>
  {
    return this.http.put
    (this.getBaseUrlForUpdateTicket(),JSON.stringify(ticket),this.getJsonContentTypeHeader()).pipe
    (map(data=>data.json()));
  }




  getBaseUrlForDeleteTicket(id):string
  {
    return this.baseUrl+"delete/"+id;
  }
  delete(id:number):Observable<Response>
  {
    return this.http.delete(this.getBaseUrlForDeleteTicket(id));
  }




  getBaseUrlForSearchTicket(field:string,value:string):string
  {
    return this.baseUrl+field+"/"+value;
  }
  searchTicket(field:string,value:string):Observable<Ticket[]>
  {
    return this.http.get(this.getBaseUrlForSearchTicket(field,value)).pipe
    (map(data=>data.json()));
  }
}
