package com.example.service;

import com.example.model.Furniture;
import com.example.model.House;

import java.util.List;

/**
 * Interface for a Furniture Service
 *
 * - Insert new Furniture to a House
 * - Get all Furniture for a House
 * - Get a Furniture by ID
 * - Update Furniture name
 * - Update Furniture size
 * - Delete Furniture
 */
public interface FurnitureService {
    /**
     * Insert a new Furniture into a specified House
     *
     * @param house the House
     * @param furniture the Furniture
     * @return the added Furniture
     */
    Furniture insertFurniture(House house, Furniture furniture);

    /**
     * Get all the Furniture for a specific House
     *
     * @param houseID id of the House to check
     * @return ArrayList of all Furniture in a House
     */
    List<Furniture> getAllFurniture(int houseID);

    /**
     * Get a Furniture by it's ID
     *
     * @param furnitureID the ID of the Furniture
     * @return the Furniture
     */
    Furniture getFurnitureByID(int furnitureID);

    /**
     * Update a Furniture with a new name and size
     *
     * @param furniture the furniture to update
     * @param newName the new name
     * @param newSize the new size
     * @return the updated Furniture
     */
    Furniture updateFurniture(Furniture furniture, String newName, double newSize);

    /**
     * Remove a Furniture
     *
     * @param furnitureID the Furniture to remove
     */
    void deleteFurniture(int furnitureID);

}
