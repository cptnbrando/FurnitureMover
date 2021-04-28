import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainComponent } from '../app/main/main.component';
import { FurnitureUpdateComponent } from './furniture-update/furniture-update.component';
import { FurnitureComponent } from './furniture/furniture.component';
import { HouseUpdateComponent } from './house-update/house-update.component';

const routes: Routes = [
  { path: '', component: MainComponent },
  { path: ':houseID/furniture', component: FurnitureComponent},
  { path: ':houseID/update', component: HouseUpdateComponent },
  { path: ':houseID/furniture/:furnitureID/update', component: FurnitureUpdateComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
