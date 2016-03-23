/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.model.Vehicle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acerpc
 */
@Local
public interface VehicleDaoLocal {
    public void addVehicle(Vehicle vehicle);
    public void editVehicle(Vehicle vehicle);
    public void deleteVehicle(String vehiclePlate);
    public Vehicle getVehicle(String vehiclePlate);
    public List<Vehicle> getAllVehicle();
}
