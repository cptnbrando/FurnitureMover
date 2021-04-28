package com.example.service;

import com.example.model.House;

import java.util.List;

/**
 * Interface for a HouseService
 */
public interface HouseService
{
    /**
     * Insert a new House
     *
     * @param newHouse a new House with a unique house ID
     * @return the inserted House
     */
    House insertHouse(House newHouse);

    /**
     * Get all the Houses in the db
     *
     * @return ArrayList of Houses
     */
    List<House> getAllHouses();

    /**
     * Get a House with an ID, if it exists
     *
     * @param houseID a valid ID
     * @return the House
     */
    House getHouseByID(int houseID);

    /**
     * Update a house
     *
     * @param house the House to update
     * @param newName a new name
     * @param newSize a new size
     * @return the updated House
     */
    House updateHouse(House house, String newName, double newSize);

    /**
     * Delete a specified House
     *
     * @param house the house
     */
    void deleteHouse(House house);
}
