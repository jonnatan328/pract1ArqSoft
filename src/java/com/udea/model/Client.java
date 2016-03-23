
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
@NamedQueries (@NamedQuery(name = "Client.getAll", query="SELECT e FROM Client e "))

public class Client implements Serializable {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column
   private long nrodocument;
   @Column
   private String name;
   @Column
   private String lastname;
   @Column
   private long telephone;
   @Column
   private String adress;
   @Column
   private long cellphone;

   public Client(long nrodocument, String name, String lastname, long telephone, String adress, long cellphone) {
        this.nrodocument = nrodocument;
        this.name = name;
        this.lastname = lastname;
        this.telephone = telephone;
        this.adress = adress;
        this.cellphone = cellphone;
   }
    
   public Client() {
    }

    public long getNrodocument() {
        return nrodocument;
    }

    public void setNrodocument(long nrodocument) {
        this.nrodocument = nrodocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getCellphone() {
        return cellphone;
    }

    public void setCellphone(long cellphone) {
        this.cellphone = cellphone;
    }
    
   
}
