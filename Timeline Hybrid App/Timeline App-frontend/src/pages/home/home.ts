import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';
import { mockSlides } from '../../mockData/mockSlides';
import { AddNewsPage } from '../addNews/addNews';
import { newsService } from '../../providers/newsService';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html',
  styles : ['./home.scss']
})
export class HomePage {

  myNews =[];
  mySlide = mockSlides;
  userInfo;

  constructor(public navCtrl: NavController, 
    public navParams: NavParams,
    public nav: NavController,
    public newsService: newsService) {
      this.userInfo = this.navParams.data.userInfo;

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad homePage');
    this.viewNewsList();
  }

  viewNewsList(){

    var list = {}
    var responseMessage=this.newsService.newsList(JSON.stringify(list));
    responseMessage.subscribe( response => {
     
    if(response["_body"]){    
        console.log(JSON.parse(response["_body"]));
        this.myNews = JSON.parse(response["_body"]);
      }

    });
    
  }

  viewMoreNews(){

    var list = {}
    var responseMessage=this.newsService.moreNews(JSON.stringify(list));
    responseMessage.subscribe( response => {
     
    if(response["_body"]){    
        console.log(JSON.parse(response["_body"]));
        this.myNews = JSON.parse(response["_body"]);
      }

    });
    
  }

  openAddNewsPage(){
    this.nav.push(AddNewsPage, {userInfo: this.userInfo});
  }

  doRefresh(refresher) {
    console.log('Begin async operation', refresher);

    setTimeout(() => {
      this.viewNewsList();
      console.log('Async operation has ended');
      refresher.complete();
    }, 1000);
  }

  doInfinite(infiniteScroll) {
    console.log('Begin async operation');

    setTimeout(() => {
    this.viewMoreNews();
    console.log('Async operation has ended');
    infiniteScroll.complete();
    }, 1000);
  }

}