package com.example.isaprojekat.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "equipmentId", nullable = false)
    private Integer equipmentId;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @JoinColumn(name = "reservationId")
    private Integer reservationId;

    public Item() {
    }
    public Item(Integer id, Integer equipmentId, Integer quantity, Integer reservation) {
        this.id = id;
        this.equipmentId = equipmentId;
        this.quantity = quantity;
        this.reservationId = reservation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getReservation() { return reservationId; }
    public void setReservation(Integer reservation) {
        this.reservationId = reservation;
    }



}