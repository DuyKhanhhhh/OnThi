package com.example.kiemtra.model;

import javax.persistence.*;

@Entity
@Table(name = "homestay")
public class HomeStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String numberOfRooms;
    private String numberOfBathrooms;
    private int price;
    private String descriptions;
    @ManyToOne
    @JoinColumn
    private City city;

    public HomeStay() {
    }

    public HomeStay( String name, String numberOfRooms, String numberOfBathrooms, int price, String descriptions, City city) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.price = price;
        this.descriptions = descriptions;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getNumberOfBathrooms() {
        return numberOfBathrooms;
    }

    public void setNumberOfBathrooms(String numberOfBathrooms) {
        this.numberOfBathrooms = numberOfBathrooms;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
