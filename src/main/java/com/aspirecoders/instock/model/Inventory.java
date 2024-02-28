package com.aspirecoders.instock.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inventory_id;

    private int admin_id;

    // private int product_id;
    private Date created_at;

    // this we are creating a foreign key column with the name "product_id"
    @OneToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    private Product product;

}
