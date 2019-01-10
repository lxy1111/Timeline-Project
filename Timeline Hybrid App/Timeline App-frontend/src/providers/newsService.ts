import { Injectable } from '@angular/core';
import { RequestOptions, Headers, Http } from '@angular/http';

@Injectable()
export class newsService {
  
  public API = 'http://localhost:8080/news';
  public responseMessage;

  constructor(public http: Http) {
  }

  newsList(message: any){
    console.log("get news list message.")
    return this.sendMessage(message,'newsList');
  }

  addNews(message: any) {
    console.log("get add news message.")
    return this.sendMessage(message,'addNews');
  }

  moreNews(message: any){
    console.log("get more messages");
    return this.sendMessage(message,'moreNews');
  }

  // get(id: string) {
  //   return this.http.get(this.Login_API + '/' + id);
  // }

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
