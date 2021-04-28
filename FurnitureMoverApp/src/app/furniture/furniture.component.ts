import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { FurnitureService } from '../furniture.service';
import { HouseService } from '../house.service';
import { Furniture } from '../models/Furniture';
import { House } from '../models/House';

@Component({
  selector: 'app-furniture',
  templateUrl: './furniture.component.html',
  styleUrls: ['./furniture.component.css']
})
export class FurnitureComponent implements OnInit
{
  house: House;
  furniture: Furniture[];
  newFurnitureName = '';
  newFurnitureSize = 0;
  possibleSize = 0;
  totalSize = 0;
  tooBig = false;

  constructor(private houseService: HouseService, private furnitureService: FurnitureService, private router: Router) { 
    this.house = JSON.parse(this.router.getCurrentNavigation().extras.state.house);
  }

  ngOnInit(): void 
  {
    this.furniture = [];
    // console.log(this.house);
    // console.log("NGINIT OF HOUSE " + this.house.houseName + " with ID: " + this.house.houseName);
    this.furnitureService.getFurniture(this.house.houseID).subscribe(data => {
        // console.log(`The output is: ${data}`);
        this.furniture = data;
        this.possibleSize = this.house.houseSize / 2;

        this.furniture.forEach(furn => {
          this.totalSize += furn.furnitureSize;
        });
      }
    );
  }

  onSubmit(): void {
    if(this.newFurnitureSize < .1)
    {
      return;
    }
    if((this.totalSize + this.newFurnitureSize) > this.possibleSize)
    {
      this.tooBig = true;
    }
    else
    {
      this.furnitureService.createFurniture(this.house.houseID, this.newFurnitureName, this.newFurnitureSize).subscribe(data => {
        this.furniture.push(data);
        this.totalSize += data.furnitureSize;
        this.tooBig = false;
      });
    }
  }

  updateFurniture(house: House, furniture: Furniture)
  {
    this.router.navigate([`/${house.houseID}/furniture/${furniture.furnitureID}/update`], 
    { 
      state: {
        house: `${JSON.stringify(house)}`,
        furniture: `${JSON.stringify(furniture)}`
      }
    });
  }

  deleteFurniture(furn : Furniture): void
  {
    this.furnitureService.deleteFurniture(this.house.houseID, furn.furnitureID).subscribe(data => {
      const index = this.furniture.indexOf(furn);
      this.totalSize -= this.furniture.splice(index, 1)[0].furnitureSize;
    })
  }
}
