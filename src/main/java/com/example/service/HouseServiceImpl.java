package com.example.service;

import com.example.model.House;
import com.example.repo.HouseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    // JPA Repository, autowired
    private HouseRepo houseRepo;

    /**
     * Insert a new House
     *
     * @param newHouse a new House with a unique house ID
     * @return the inserted House
     */
    @Override
    public House insertHouse(House newHouse) {
        try {
            return houseRepo.save(newHouse);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get all the Houses in the db
     *
     * @return ArrayList of Houses
     */
    @Override
    public List<House> getAllHouses() {
        return houseRepo.findAll();
    }

    /**
     * Get a House with an ID, if it exists
     *
     * @param houseID a valid ID
     * @return the House
     */
    @Override
    public House getHouseByID(int houseID) {
        try {
            return houseRepo.findById(houseID).get();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Update a house
     *
     * @param house the House to update
     * @param newName a new name
     * @param newSize a new size
     * @return the updated House
     */
    @Override
    public House updateHouse(House house, String newName, double newSize) {
        house.setHouseName(newName);
        house.setHouseSize(newSize);
        return houseRepo.save(house);
    }

    /**
     * Delete a specified House
     *
     * @param house the house
     */
    @Override
    public void deleteHouse(House house) {
        try {
            houseRepo.delete(house);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public HouseServiceImpl() {
    }

    public HouseServiceImpl(HouseRepo houseRepo) {
        this.houseRepo = houseRepo;
    }

    public HouseRepo getHouseRepo() {
        return houseRepo;
    }

    @Autowired
    public void setHouseRepo(HouseRepo houseRepo) {
        this.houseRepo = houseRepo;
    }
}
