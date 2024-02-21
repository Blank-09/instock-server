package com.aspirecoders.instock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspirecoders.instock.model.Inventory;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    // You can add custom query methods here if needed
}
