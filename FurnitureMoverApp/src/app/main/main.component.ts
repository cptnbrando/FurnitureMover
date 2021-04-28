import { Component, OnInit } from '@angular/core';
import { HouseService } from '../house.service';
import { House } from '../models/House';
import { Router } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';

@Component({
  selector: 'main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit
{
  houses: House[];
  newHouseName = '';
  newHouseSize = 0;

  constructor(private houseService: HouseService, private router: Router) {

  }

  ngOnInit(): void {
    this.houses = [];
    this.houseService.getAllHouses().subscribe(
      data => {
        this.houses = data;
      }
    )
  }

  onSubmit(): void {
    if(this.newHouseName.length > 0 && this.newHouseSize != 0)
    {
      this.houseService.createHouse(this.newHouseName, this.newHouseSize).subscribe(data => {
        this.houses.push(data);
      });
    }
  }

  showFurniture(house : House)
  {
    this.router.navigate([`/${house.houseID}/furniture`], { state: { house: `${JSON.stringify(house)}` } });
  }

  updateHouse(house: House)
  {
    this.router.navigate([`/${house.houseID}/update`], { state: { house: `${JSON.stringify(house)}` } });
  }

  deleteHouse(house : House) : void
  {
    this.houseService.deleteHouse(house.houseID).subscribe(data => {
      const index = this.houses.indexOf(house);
      this.houses.splice(index, 1);
    })
  }

}
