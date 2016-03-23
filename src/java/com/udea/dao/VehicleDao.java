
package com.udea.dao;

import com.udea.model.Vehicle;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class VehicleDao implements VehicleDaoLocal {
    @PersistenceContext(unitName = "Laboratorio1PU")
    private EntityManager em;

    @Override
    public void addVehicle(Vehicle vehicle) {
        em.persist(vehicle);
    }

    @Override
    public void editVehicle(Vehicle vehicle) {
         em.merge(vehicle);
    }

    @Override
    public void deleteVehicle(String vehiclePlate) {
        em.remove(getVehicle(vehiclePlate));
    }

    @Override
    public Vehicle getVehicle(String vehiclePlate) {
        return em.find(Vehicle.class, vehiclePlate);
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return em.createNamedQuery("Vehicle.getAll").getResultList();
    }
    
}
