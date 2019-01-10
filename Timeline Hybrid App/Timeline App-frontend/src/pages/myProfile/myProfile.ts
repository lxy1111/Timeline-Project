import { Component } from '@angular/core';
import { mockNews } from '../../mockData/mockNews';
import { NavParams } from '../../../node_modules/ionic-angular';

@Component({
  templateUrl: 'myProfile.html'
})
export class MyProfilePage {

    public myNews = mockNews;
    userInfo;

    constructor(public navParams: NavParams) {
      this.userInfo=navParams.data.userInfo;
     
    }
  
}