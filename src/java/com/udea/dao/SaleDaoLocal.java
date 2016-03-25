/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.model.Sale;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Daego_000
 */
@Local
public interface SaleDaoLocal {

    void addSale(Sale sale);

    void editSale(Sale sale);

    void deleteSale(long id);

    Sale getSale(long id);

    List<Sale> getAllSales();
    
}
