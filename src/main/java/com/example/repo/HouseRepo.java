package com.example.repo;

import com.example.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Houses
 * Uses Java Persistence API to generate DB getters/setters
 */
@Repository
public interface HouseRepo extends JpaRepository<House, Integer> {
    @Modifying
    @Query(value = "DELETE FROM house WHERE house_id = ?1", nativeQuery = true)
    void deleteByHouseID(int houseID);
}
