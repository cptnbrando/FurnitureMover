package com.example.controller;

import com.example.model.Furniture;
import com.example.model.House;
import com.example.service.FurnitureServiceImpl;
import com.example.service.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Furniture
 *
 * - {houseID}/furniture = list of all Furniture in House
 * - {houseID}/furniture/{furnitureID} = get a specific Furniture
 * - {houseID}/furniture/addFurniture = create a new Furniture
 * - {houseID}/furniture/{furnitureID}/updateFurniture = change name or size of a specific House
 * - {houseID}/furniture/{furnitureID}/deleteFurniture = delete a House (and all associated Furniture)
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/api/{houseID}/furniture")
public class FurnitureController
{
    // Services that are autowired
    private HouseServiceImpl houseService;
    private FurnitureServiceImpl furnitureService;

    /**
     * Add a new Furniture to a House
     *
     * @param houseID the House to add to
     * @param newFurniture the Furniture to add
     * @return the added Furniture
     */
    @PostMapping(value = "/addFurniture")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Furniture addFurniture(@PathVariable("houseID") int houseID, @RequestBody Furniture newFurniture)
    {
        House myHouse = houseService.getHouseByID(houseID);
        return furnitureService.insertFurniture(myHouse, newFurniture);
    }

    /**
     * Get all the Furniture for a specified House
     *
     * @param houseID the house
     * @return List of Furniture
     */
    @GetMapping(value = "")
    public List<Furniture> getAllFurniture(@PathVariable("houseID") int houseID)
    {
        return furnitureService.getAllFurniture(houseID);
    }

    /**
     * Get a Furniture for a specified ID
     *
     * @param furnitureID the furniture id
     * @return the furniture
     */
    @GetMapping(value = "/{furnitureID}")
    public Furniture getFurniture(@PathVariable("furnitureID") int furnitureID)
    {
        return furnitureService.getFurnitureByID(furnitureID);
    }

    /**
     * Update a Furniture
     *
     * @param furnitureID the furniture id
     * @param update a Furniture with updated fields
     * @return an updated Furniture
     */
    @PutMapping(value = "/{furnitureID}/updateFurniture")
    public Furniture updateFurniture(@PathVariable("furnitureID") int furnitureID, @RequestBody Furniture update)
    {
        String newName = update.getFurnitureName();
        double newSize = update.getFurnitureSize();

        Furniture myFurn = furnitureService.getFurnitureByID(furnitureID);

        return furnitureService.updateFurniture(myFurn, newName, newSize);
    }

    /**
     * Delete a Furniture
     *
     * @param furnitureID the furniture id
     */
    @DeleteMapping(value = "/{furnitureID}/deleteFurniture")
    public void deleteFurniture(@PathVariable("furnitureID") int furnitureID)
    {
        furnitureService.deleteFurniture(furnitureID);
    }

    public FurnitureController() {
    }

    @Autowired
    public FurnitureController(HouseServiceImpl houseService, FurnitureServiceImpl furnitureService) {
        this.houseService = houseService;
        this.furnitureService = furnitureService;
    }

    public HouseServiceImpl getHouseService() {
        return houseService;
    }

    public void setHouseService(HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    public FurnitureServiceImpl getFurnitureService() {
        return furnitureService;
    }

    public void setFurnitureService(FurnitureServiceImpl furnitureService) {
        this.furnitureService = furnitureService;
    }
}
