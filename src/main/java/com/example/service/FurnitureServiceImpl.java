package com.example.service;

import com.example.model.Furniture;
import com.example.model.House;
import com.example.repo.FurnitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService
{
    // JPA Repository, autowired
    private FurnitureRepo furnitureRepo;

    /**
     * Insert a new Furniture into a specified House
     *
     * @param house the House
     * @param furniture the Furniture
     * @return the added Furniture
     */
    @Override
    public Furniture insertFurniture(House house, Furniture furniture) {
        try {
            furniture.setMyHouse(house);
            return furnitureRepo.save(furniture);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get all the Furniture for a specific House
     *
     * @param houseID id of the House to check
     * @return ArrayList of all Furniture in a House
     */
    @Override
    public List<Furniture> getAllFurniture(int houseID) {
        try {
            return furnitureRepo.findByHouseID(houseID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get a Furniture by it's ID
     *
     * @param furnitureID the ID of the Furniture
     * @return the Furniture
     */
    @Override
    public Furniture getFurnitureByID(int furnitureID) {
        try {
            return furnitureRepo.findById(furnitureID).get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update a Furniture with a new name and size
     *
     * @param furniture the furniture to update
     * @param newName the new name
     * @param newSize the new size
     * @return the updated Furniture
     */
    @Override
    public Furniture updateFurniture(Furniture furniture, String newName, double newSize) {
        furniture.setFurnitureName(newName);
        furniture.setFurnitureSize(newSize);
        return furnitureRepo.save(furniture);
    }

    /**
     * Remove a Furniture
     *
     * @param furnitureID the Furniture to remove
     */
    @Override
    public void deleteFurniture(int furnitureID) {
        try{
            furnitureRepo.deleteByFurnitureID(furnitureID);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public FurnitureServiceImpl() {
    }

    public FurnitureServiceImpl(FurnitureRepo furnitureRepo) {
        this.furnitureRepo = furnitureRepo;
    }

    public FurnitureRepo getFurnitureRepo() {
        return furnitureRepo;
    }

    @Autowired
    public void setFurnitureRepo(FurnitureRepo furnitureRepo) {
        this.furnitureRepo = furnitureRepo;
    }
}
