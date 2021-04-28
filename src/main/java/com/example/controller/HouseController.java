package com.example.controller;

import com.example.model.House;
import com.example.service.FurnitureServiceImpl;
import com.example.service.HouseService;
import com.example.service.HouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for Houses
 *
 * - house/ = list of all current Houses
 * - house/{houseID} = get a specific House
 * - house/addHouse = create a new House
 * - house/{houseID}/updateHouse = change name or size of a specific House
 * - house/{houseID}/deleteHouse = delete a House (and all associated Furniture)
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class HouseController
{
    // Services that are autowired
    private HouseServiceImpl houseService;
    private FurnitureServiceImpl furnitureService;

    /**
     * Get all the Houses in the system
     *
     * @return List of Houses
     */
    @GetMapping(value = "")
    @ResponseStatus(value = HttpStatus.OK)
    public List<House> getAllHouses()
    {
        return houseService.getAllHouses();
    }

    /**
     * Get a specific House
     *
     * @param houseID the House id
     * @return the House
     */
    @GetMapping(value = "/{houseID}")
    @ResponseStatus(value = HttpStatus.OK)
    public House getHouseByID(@PathVariable("houseID") int houseID)
    {
        return houseService.getHouseByID(houseID);
    }

    /**
     * Add a new House to the db
     *
     * @param incoming a new House
     * @return a House that was successfully added
     */
    @PostMapping(value="/addHouse")
    @ResponseStatus(value = HttpStatus.CREATED)
    public House addHouse(@RequestBody House incoming) {
        return houseService.insertHouse(incoming);
    }

    /**
     * Update a House
     *
     * @param houseID the house to update
     * @param update a House with different name/size
     * @return an updated House
     */
    @PutMapping(value = "/{houseID}/updateHouse")
    public House updateHouse(@PathVariable("houseID") int houseID, @RequestBody House update) {

        String newHouseName = update.getHouseName();
        double newHouseSize = update.getHouseSize();

        House theHouse = houseService.getHouseByID(houseID);

        return houseService.updateHouse(theHouse, newHouseName, newHouseSize);
    }

    /**
     * Delete a House (and all associated furniture implicitly)
     *
     * @param houseID the house
     */
    @DeleteMapping(value = "/{houseID}/deleteHouse")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteHouse(@PathVariable("houseID") int houseID) {
        House theHouse = houseService.getHouseByID(houseID);
        houseService.deleteHouse(theHouse);
    }

    public HouseController() {
    }

    @Autowired
    public HouseController(HouseServiceImpl houseService, FurnitureServiceImpl furnitureService) {
        this.houseService = houseService;
        this.furnitureService = furnitureService;
    }

    public HouseService getHouseService() {
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
