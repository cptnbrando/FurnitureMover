package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for a House, which holds many Furniture objects
 *
 * - Size to set amount of possible furniture
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "house")
public class House
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private int houseID;

    @Column(name = "house_name", nullable = false)
    private String houseName;

    @Column(name = "house_size", nullable = false)
    private double houseSize;

    @OneToMany(mappedBy = "myHouse", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Furniture> myFurniture;

    /**
     * This is useful for incoming Houses without an id or initial furniture list
     * Used in Update methods
     *
     * @param houseName Name of House
     * @param houseSize Size of House
     */
    public House(String houseName, double houseSize) {
        this.houseName = houseName;
        this.houseSize = houseSize;
        this.myFurniture = new ArrayList<>();
    }
}
