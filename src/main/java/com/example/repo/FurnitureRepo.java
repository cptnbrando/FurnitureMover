package com.example.repo;

import com.example.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Furniture
 * Uses Java Persistence API to generate getters/setters for DB
 */
@Repository
public interface FurnitureRepo extends JpaRepository<Furniture, Integer> {

    /**
     * Find all the Furniture for a specific House
     *
     * @param houseID the House ID
     * @return a List of Furniture
     */
    @Query(value = "SELECT * FROM furniture WHERE house_fk = ?1", nativeQuery = true)
    List<Furniture> findByHouseID(int houseID);

    /**
     * Delete a Furniture based on their ID
     *
     * @param furnitureID the Furniture ID
     */
    @Modifying
    @Query(value = "DELETE FROM furniture WHERE furniture_id = ?1", nativeQuery = true)
    void deleteByFurnitureID(int furnitureID);
}
