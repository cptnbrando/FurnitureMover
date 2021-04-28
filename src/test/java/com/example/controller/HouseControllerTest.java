package com.example.controller;

import com.example.model.Furniture;
import com.example.model.House;
import com.example.repo.HouseRepo;
import com.example.service.FurnitureServiceImpl;
import com.example.service.HouseService;
import com.example.service.HouseServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class HouseControllerTest {

    HouseController houseController;

    @Mock
    HouseServiceImpl houseService;

    @Mock
    FurnitureServiceImpl furnitureService;

    @BeforeEach
    void setUp() {
        houseController = new HouseController(houseService, furnitureService);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllHouses() {
        // Initial condition
        ArrayList<House> testHouses = new ArrayList<>();
        testHouses.add(new House(1, "Test House 1", 5000, new ArrayList<>()));
        testHouses.add(new House(2, "Test House 2", 3000, new ArrayList<>()));
        testHouses.add(new House(3, "Test House 3", 2570.46, new ArrayList<>()));

        Mockito.when(houseService.getAllHouses()).thenReturn(testHouses);

        List<House> actualHouses = houseController.getAllHouses();

        Mockito.verify(houseService).getAllHouses();

        assertEquals(testHouses, houseController.getAllHouses());
    }

    @Test
    void getHouseByID() {
        House testHouse = new House(1, "addHouseTest1", 1400.85, new ArrayList<>());

        Mockito.when(houseService.getHouseByID(1)).thenReturn(testHouse);

        House actualHouse = houseController.getHouseByID(1);

        Mockito.verify(houseService).getHouseByID(1);

        assertEquals(testHouse, actualHouse);
    }

    @Test
    void addHouse() {
        House testHouse = new House(1, "addHouseTest1", 1400.85, new ArrayList<>());

        Mockito.when(houseService.insertHouse(testHouse)).thenReturn(testHouse);

        House actualHouse = houseController.addHouse(testHouse);

        Mockito.verify(houseService).insertHouse(testHouse);

        assertEquals(testHouse, actualHouse);
    }

    @Test
    void updateHouse() {
        // Test changing name
        House testHouse = new House(1, "updateHouseTest1", 1400.85, new ArrayList<>());

        Mockito.when(houseService.getHouseByID(1)).thenReturn(testHouse);

        House updatedName = new House(1, "new name 1", 1400.85, new ArrayList<>());
        houseController.updateHouse(1, updatedName);

        assertEquals(updatedName, houseController.getHouseByID(1));

        // Test changing size
        House updatedSize = new House(1, "new name 1", 700, new ArrayList<>());
        houseController.updateHouse(1, updatedSize);

        assertEquals(updatedSize, houseController.getHouseByID(1));
    }

    @Test
    void deleteHouse() {
    }
}