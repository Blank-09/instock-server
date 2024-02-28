package com.aspirecoders.instock.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long inventoryId;

    private String adminId;

    @Column(columnDefinition = "TIMESTAMP")
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

    // this we are creating a foreign key column with the name "product_id"
    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Product product;

}
