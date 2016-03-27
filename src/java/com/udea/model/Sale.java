package com.udea.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table
@NamedQueries(
        @NamedQuery(name = "Sale.getAll", query = "SELECT s FROM Sale s "))
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    @JoinColumn (name = "client")
    @OneToOne
    private Client client;
    @JoinColumn (name = "vehicle")
    @OneToOne
    private Vehicle vehicle;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    @Column
    private int installments;
    @Column
    private long installment_amount;

    public Sale() {
    }

    public Sale(long id, Client client, Vehicle vehicle, Date date, int installments, long installments_amount) {
        this.id = id;
        this.client = client;
        this.vehicle = vehicle;
        this.date = date;
        this.installments = installments;
        this.installment_amount = installments_amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getInstallments() {
        return installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public long getInstallment_amount() {
        return installment_amount;
    }

    public void setInstallment_amount(long installment_amount) {
        this.installment_amount = installment_amount;
    }


}
