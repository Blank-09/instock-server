package com.aspirecoders.instock.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventoryId;
    private long adminId;
    private long productId;
    private int stocks;
    private Date createdAt;

}
