import { Component } from '@angular/core';
import { NavController, AlertController } from 'ionic-angular';
import { RegisterPage } from './register';
import { usersService } from '../../providers/usersService';
import { TabsPage } from '../tabs/tabs';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
  styles: ['./login.scss'],
})

export class LoginPage {

  private userInfo;

  constructor(public navCtrl: NavController,
    public usersService: usersService,
    public alertCtrl: AlertController) {

  }

  showAlert() {
    const alert = this.alertCtrl.create({
      title: '错误提示',
      subTitle: '用户名或密码有误',
      buttons: ['确认']
    });
    alert.present();
  }

  login(username,password)
  {
    if(!username||!password)
    {
      this.showAlert();
      return;
    }
    
    var users = {
       "username":username,
       "password":password
    }
    console.log(users);
    console.log(users['username']);
    console.log(JSON.stringify(users));
    this.usersService.login(JSON.stringify(users));
     
    var responseMessage=this.usersService.login(JSON.stringify(users));
    responseMessage.subscribe( response => {
      
      if(response["_body"]=="true"){    
        this.userInfo=username;
        this.navCtrl.push(TabsPage,{ userInfo: this.userInfo});
      }
      else{
        this.showAlert();
      }
           
    });
     
  }

  register(){
    this.navCtrl.push(RegisterPage);
  }

}
