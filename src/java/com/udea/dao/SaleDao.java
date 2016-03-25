package com.udea.dao;

import com.udea.model.Sale;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SaleDao implements SaleDaoLocal {
    @PersistenceContext(unitName = "Laboratorio1PU")
    private EntityManager em;    

    @Override
    public void addSale(Sale sale) {
        em.persist(sale);
    }

    @Override
    public void editSale(Sale sale) {
        em.merge(sale);
    }

    @Override
    public void deleteSale(long id) {
        em.remove(getSale(id));
    }

    @Override
    public Sale getSale(long id) {        
        return em.find(Sale.class, id);
    }

    @Override
    public List<Sale> getAllSales() {
        return em.createNamedQuery("Sale.getAll").getResultList();
    }
}
