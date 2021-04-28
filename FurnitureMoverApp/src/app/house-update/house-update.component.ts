import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HouseService } from '../house.service';
import { House } from '../models/House';

@Component({
  selector: 'app-house-update',
  templateUrl: './house-update.component.html',
  styleUrls: ['./house-update.component.css']
})
export class HouseUpdateComponent implements OnInit {

  house: House;
  newHouseName: String;
  newHouseSize: number;

  constructor(private houseService: HouseService, private router: Router) {
    this.house = JSON.parse(this.router.getCurrentNavigation().extras.state.house);
  }

  ngOnInit(): void {
    this.newHouseName = this.house.houseName;
    this.newHouseSize = this.house.houseSize;
  }

  onSubmit(): void {
    if(this.newHouseName.length === 0)
    {
      this.newHouseName = this.house.houseName;
    }
    if(this.newHouseSize === 0)
    {
      this.newHouseSize = this.house.houseSize;
    }
    this.houseService.updateHouse(this.house.houseID, this.newHouseName, this.newHouseSize).subscribe(data => {
      data.myFurniture = [];
      this.house = data;
    });
  }

}
