package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "furniture")
public class Furniture
{
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "furniture_id")
    private int furnitureID;

    @Column(name = "furniture_name", nullable = false)
    private String furnitureName;

    @Column(name = "furniture_size", nullable = false)
    private double furnitureSize;

    @ManyToOne
    @JoinColumn(name = "house_fk")
    @JsonIgnore
    private House myHouse;

    /**
     * This is needed for incoming Furniture objects without an id or initial house
     * Useful for the update methods
     *
     * @param furnitureName Name of furniture
     * @param furnitureSize Size of furniture
     */
    public Furniture(String furnitureName, double furnitureSize) {
        this.furnitureName = furnitureName;
        this.furnitureSize = furnitureSize;
        this.myHouse = null;
    }
}
