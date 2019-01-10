import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RequestOptions, Headers, Http } from '@angular/http';

@Injectable()
export class usersService {
  public API = 'http://localhost:8080/users';
  public responseMessage;

  constructor(public http: Http) {
    
  }

  login(message: any){      
    console.log("get login message.")
    return this.sendMessage(message, 'login');
  }

  register(message: any){      
    console.log("get register message.")
    return this.sendMessage(message, 'register');
  }

  // get(id: string) {
  //   return this.http.get(this.Login_API + '/' + id);
  // }

  getMessage(): Observable<any> {
    console.log("getmessage.")
    return this.http.get(this.API + '/getMessage');
  }

  sendMessage(message: any, controllerURL){
    const url = this.API + '/' + controllerURL;
    const headers = new Headers({ 'Accept': 'application/json', 'Content-Type' : 'application/x-www-form-urlencoded' });
    const options = new RequestOptions( { headers:headers } );
    this.responseMessage = this.http.post(url, `message=${ message }`, options);
    console.log(this.responseMessage);
    return this.responseMessage;
  }

  // remove(id: string) {
  //   return this.http.delete(this.Login_API + '/' + id);
  // }
}
