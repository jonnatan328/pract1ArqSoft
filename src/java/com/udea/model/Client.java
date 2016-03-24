
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
   private String phone;
   @Column
   private String address;
   @Column
   private String cellphone;

   public Client(long nrodocument, String name, String lastname, String telephone, String adress, String cellphone) {
        this.nrodocument = nrodocument;
        this.name = name;
        this.lastname = lastname;
        this.phone = telephone;
        this.address = adress;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
    
   
}
