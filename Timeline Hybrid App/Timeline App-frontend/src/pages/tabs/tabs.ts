import { Component } from '@angular/core';
import { HomePage } from '../home/home';
import { MyProfilePage } from '../myProfile/myProfile';
import { NavParams } from '../../../node_modules/ionic-angular';
@Component({
  templateUrl: 'tabs.html'
})
export class TabsPage {

  userInfo;
  tab1Root = HomePage;
  tab2Root = MyProfilePage;

  constructor(public navParams:NavParams) {
    this.userInfo=navParams.data.userInfo;
  }

}
