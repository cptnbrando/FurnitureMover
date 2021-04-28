package com.example.service;

import com.example.model.Furniture;
import com.example.model.House;
import com.example.repo.FurnitureRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FurnitureServiceImplTest {

    private FurnitureServiceImpl furnitureService;

    private HouseServiceImpl houseService;

    @Mock
    private FurnitureRepo furnitureRepo;

    private House testHouse;

    @BeforeEach
    void setUp() {
        houseService = new HouseServiceImpl();
        furnitureService = new FurnitureServiceImpl(furnitureRepo);
        testHouse = new House("testHouse", 1500);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void insertFurniture() {
        // Initial new Furniture
        Furniture test1 = new Furniture("test1", 450);

        // Set Mockito when
        Mockito.when(furnitureRepo.save(test1)).thenReturn(test1);

        Furniture insert = furnitureService.insertFurniture(testHouse, test1);

        assertEquals(test1, insert);
    }

    @Test
    void getAllFurniture() {
        ArrayList<Furniture> furnitureList = new ArrayList<>();
        furnitureList.add(new Furniture(1, "Test House 1 Furniture 1", 25.86, testHouse));
        furnitureList.add(new Furniture(2, "Test House 1 Furniture 2", 45.67, testHouse));
        furnitureList.add(new Furniture(3, "Test House 1 Furniture 3", 2.66, testHouse));
        furnitureList.add(new Furniture(4, "Test House 2 Furniture 1", 17, testHouse));
        furnitureList.add(new Furniture(5, "Test House 2 Furniture 2", 268, testHouse));
        furnitureList.add(new Furniture(6, "Test House 3 Furniture 1", 22.66, testHouse));

        Mockito.when(furnitureRepo.findByHouseID(1)).thenReturn(furnitureList);

        assertEquals(furnitureList, furnitureService.getAllFurniture(1));

    }

    @Test
    void getFurnitureByID() {
        Furniture furn1 = new Furniture(1, "Test House 1 Furniture 1", 25.86, testHouse);

        assertEquals(furn1, furnitureService.getFurnitureByID(1));
    }

    @Test
    void updateFurniture() {
        Furniture furn1 = new Furniture(1, "Test House 1 Furniture 1", 25.86, testHouse);

        Furniture update = new Furniture(1, "Changed Name", 500, testHouse);

        assertEquals(update, furnitureService.updateFurniture(furn1, update.getFurnitureName(), update.getFurnitureSize()));
    }

    @Test
    void deleteFurniture() {
        Furniture furn1 = new Furniture(1, "Test House 1 Furniture 1", 25.86, testHouse);

        furnitureService.deleteFurniture(1);

        assertNull(furnitureService.getFurnitureByID(1));
    }
}