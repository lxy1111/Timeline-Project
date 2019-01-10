import { Component } from '@angular/core';
import { NavController, AlertController } from 'ionic-angular';
import { TabsPage } from '../tabs/tabs';
import { usersService } from '../../providers/usersService';
import { LoginPage } from './login';

@Component({
  selector: 'page-register',
  templateUrl: 'register.html',
  styles: ['./register.scss'],
})
export class RegisterPage {

  private userInfo;

  constructor(public navCtrl: NavController,
              public alertCtrl: AlertController,
              public usersService: usersService) {

  }

  enterHome(){
    this.navCtrl.push(TabsPage);
  }

  showAlert1() {
    const alert = this.alertCtrl.create({
      title: '错误提示',
      subTitle: '密码不一致',
      buttons: ['确认']
    });
    alert.present();
  }

  showAlert2(){
    const alert = this.alertCtrl.create({
      title: '错误提示',
      subTitle: '该用户已存在',
      buttons: ['确认']
    });
    alert.present();
  }

  showAlert3() {
    const alert = this.alertCtrl.create({
      title: '错误提示',
      subTitle: '请完善个人信息',
      buttons: ['确认']
    });
    alert.present();
  }

  register(username,password1,password2){
      if(!password1||!password2||!username)
      {
        this.showAlert3();
        return;
      }
      if(password1!=password2){
        this.showAlert1();
      }     
      else{
        var users={
        "username": username,
        "password": password1
        }

        var responseMessage = this.usersService.register(JSON.stringify(users));
        responseMessage.subscribe( response => {

        console.log(response);
        if(response["_body"]=="true"){
            this.navCtrl.push(LoginPage,this.userInfo);
        }
        else{
          this.showAlert2();
        }
      
        }); 
  
      }
  }


}
