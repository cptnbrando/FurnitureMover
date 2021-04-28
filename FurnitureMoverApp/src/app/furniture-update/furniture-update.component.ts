import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FurnitureService } from '../furniture.service';
import { Furniture } from '../models/Furniture';
import { House } from '../models/House';

@Component({
  selector: 'app-furniture-update',
  templateUrl: './furniture-update.component.html',
  styleUrls: ['./furniture-update.component.css']
})
export class FurnitureUpdateComponent implements OnInit {

  house: House;
  furniture: Furniture;
  newFurnitureName: String;
  newFurnitureSize: number;

  constructor(private router: Router, private furnitureService: FurnitureService) {
    this.house = JSON.parse(this.router.getCurrentNavigation().extras.state.house);
    this.furniture = JSON.parse(this.router.getCurrentNavigation().extras.state.furniture);
  }

  ngOnInit(): void {
    this.newFurnitureName = this.furniture.furnitureName;
    this.newFurnitureSize = this.furniture.furnitureSize;
  }

  backToFurniture(): void {
    this.router.navigate([`/${this.house.houseID}/furniture`], { state: { house: `${JSON.stringify(this.house)}` } });
  }

  onSubmit(): void {
    if(this.newFurnitureName.length === 0)
    {
      this.newFurnitureName = this.furniture.furnitureName;
    }
    if(this.newFurnitureSize === 0)
    {
      this.newFurnitureSize = this.furniture.furnitureSize;
    }

    this.furnitureService.updateFurniture(this.house.houseID, this.furniture.furnitureID, this.newFurnitureName, this.newFurnitureSize).subscribe(data => {
      this.furniture = data;
    });
  }

}
