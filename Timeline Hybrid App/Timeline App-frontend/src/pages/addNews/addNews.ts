import { Component } from '@angular/core';
import { NavController,NavParams, AlertController } from 'ionic-angular';
import { TabsPage } from '../tabs/tabs';
import { newsService } from '../../providers/newsService';

@Component({
  templateUrl: 'addNews.html',
  styles: ['./addNews.scss']
})

export class AddNewsPage {
  
  userInfo;
  img : String;
  content : String;

  constructor(public navCtrl: NavController,
            public navParams: NavParams,
            public alertCtrl: AlertController,
            public newsService: newsService
             ) {
         this.userInfo=navParams.data.userInfo;
  }

  showAlert1() {
    const alert = this.alertCtrl.create({
      title: '错误提示',
      subTitle: '请填写分享内容',
      buttons: ['确认']
    });
    alert.present();
  }

  showAlert2() {
    const alert = this.alertCtrl.create({
      title: '错误提示',
      subTitle: '分享失败',
      buttons: ['重试']
    });
    alert.present();
  }

  addNews(image, content){
    
    if((!content)&&(!image))
    {  
      this.showAlert1();
      return;
    }

    if(!image){
      this.img = "";
    }else{
      this.img = image.replace("C:\\fakepath\\","");
    }

    if(!content){
      this.content = "";
    }else{
      this.content = content;
    }

    var message = {
        "content": this.content,
        "imageURL": this.img,
        "author": this.userInfo
    }

    var responseMessage=this.newsService.addNews(JSON.stringify(message));
    responseMessage.subscribe( response => {
        if(response["_body"]=="true"){
          this.navCtrl.push(TabsPage, {userInfo: this.userInfo});
        }
        else{
          this.showAlert2();
        }
     });
    
  }

}
