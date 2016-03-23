
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
   private byte image[];

    public Vehicle(String plate, String brand, String model, int year, byte[] image) {
        this.plate = plate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.image = image;
    }

    public Vehicle() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
   
   
}
