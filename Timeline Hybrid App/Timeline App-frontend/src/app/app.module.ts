import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HttpClientModule } from '@angular/common/http';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { RegisterPage } from '../pages/login/register';
import { TabsPage } from '../pages/tabs/tabs';
import { MyProfilePage } from '../pages/myProfile/myProfile';
import { AddNewsPage } from '../pages/addNews/addNews';
import { usersService } from '../providers/usersService';
import { newsService } from '../providers/newsService';
import { HttpModule } from '../../node_modules/@angular/http';

@NgModule({
  declarations: [
    MyApp,
    HomePage,
    LoginPage,
    RegisterPage,
    TabsPage,
    MyProfilePage,
    AddNewsPage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    HttpClientModule,
    HttpModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    LoginPage,
    RegisterPage,
    TabsPage,
    MyProfilePage,
    AddNewsPage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    usersService,
    newsService,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
