
package com.udea.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries (@NamedQuery(name = "Vehicle.getAll", query="SELECT v FROM Vehicle v "))
public class Vehicle implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column
   private String plate;
   @Column
   private String brand;
   @Column
   private String model;
   @Column
   private int year;
   @Column
   private String color;
   @Column
   private String fuel;
   @Column
   private String transmission;
   @Column
   private int doors;
   @Column
   private long price;
   @Column
   private String image;   

    public Vehicle() {
    }

    public Vehicle(String plate, String brand, String model, int year, String color, String fuel, String transmission, int doors, long price, String image) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.fuel = fuel;
        this.transmission = transmission;
        this.doors = doors;
        this.price = price;
        this.image = image;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
   
   
   
}
