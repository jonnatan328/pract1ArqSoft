
package com.udea.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

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
   @Column
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date birthDate;

    public Client() {
    }

    public Client(long nrodocument, String name, String lastname, String phone, String address, String cellphone, Date birthDate) {
        this.nrodocument = nrodocument;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.cellphone = cellphone;
        this.birthDate = birthDate;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
   
   
}
