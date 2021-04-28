import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { AppRoutingModule } from './app-routing.module';
import { FurnitureComponent } from './furniture/furniture.component';
import { FormsModule } from '@angular/forms';
import { HouseUpdateComponent } from './house-update/house-update.component';
import { FurnitureUpdateComponent } from './furniture-update/furniture-update.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    FurnitureComponent,
    HouseUpdateComponent,
    FurnitureUpdateComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
