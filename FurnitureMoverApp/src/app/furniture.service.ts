import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Furniture } from './models/Furniture';

@Injectable({
  providedIn: 'root'
})
export class FurnitureService {
  // Root url for api
  private url = "http://localhost:8080/api";

  constructor(private httpCli: HttpClient) { }

  /**
   * Get all Furniture for a specified House
   * 
   * @param houseID the ID of the House
   * @returns http.get client
   */
  getFurniture(houseID: number): Observable<Furniture[]>
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    // console.log("Getting furniture from: " + `${this.url}/${houseID}/furniture`);

    return this.httpCli.get<Furniture[]>(`${this.url}/${houseID}/furniture`, options);
  }

  /**
   * Add a new Furniture to a House
   * 
   * @param houseID the House
   * @param newFurnitureName the name of the Furniture
   * @param newFurnitureSize the size of the Furniture
   * @returns http.post client
   */
  createFurniture(houseID: number, newFurnitureName: String, newFurnitureSize: Number): Observable<Furniture>
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    const body = `{
      "furnitureName": "${newFurnitureName}",
      "furnitureSize": ${newFurnitureSize}
    }`;
    
    return this.httpCli.post<Furniture>(`${this.url}/${houseID}/furniture/addFurniture`, body, options);
  }

  /**
   * Update a Furniture
   * 
   * @param houseID The house
   * @param furnitureID The furniture
   * @param newFurnitureName An updated name
   * @param newFurnitureSize An updated size
   * @returns http.put client
   */
  updateFurniture(houseID: number, furnitureID: number, newFurnitureName: String, newFurnitureSize: Number)
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    const body = `{
      "furnitureName": "${newFurnitureName}",
      "furnitureSize": ${newFurnitureSize}
    }`;
    
    return this.httpCli.put<Furniture>(`${this.url}/${houseID}/furniture/${furnitureID}/updateFurniture`, body, options);
  }

  /**
   * Delete a Furniture
   * 
   * @param houseID The house
   * @param furnitureID The furniture
   * @returns http.delete client
   */
  deleteFurniture(houseID : number, furnitureID : number)
  {
    const options = { 
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    }

    console.log(`DELETING FURNITURE ${furnitureID} IN HOUSE ${houseID}`);
    console.log(`URL: ${this.url}/${houseID}/furniture/${furnitureID}/deleteFurniture`);

    return this.httpCli.delete<Furniture>(`${this.url}/${houseID}/furniture/${furnitureID}/deleteFurniture`, options);
  }
}
