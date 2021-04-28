import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from "@angular/common/http";
import { Observable } from 'rxjs';
import { House } from './models/House';

@Injectable({
  providedIn: 'root'
})
export class HouseService {

  private url = "http://localhost:8080/api";

  constructor(private httpCli: HttpClient) {
    
  }

  getAllHouses(): Observable<House[]> 
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }
    
    return this.httpCli.get<House[]>(this.url, options);
  }

  createHouse(newHouseName: String, newHouseSize: Number):Observable<House>
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    const body = `{
      "houseName": "${newHouseName}",
      "houseSize": ${newHouseSize}
    }`;
    
    return this.httpCli.post<House>(`${this.url}/addHouse`, body, options);
  }

  updateHouse(houseID: number, houseName: String, houseSize: number)
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    const payload = `{
      "houseName": "${houseName}",
      "houseSize": ${houseSize}
    }`

    return this.httpCli.put<House>(`${this.url}/${houseID}/updateHouse`, payload, options);
  }

  deleteHouse(houseID : number)
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    return this.httpCli.delete<House>(`${this.url}/${houseID}/deleteHouse`, options);
  }
}
