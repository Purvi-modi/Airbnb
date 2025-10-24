package com.projects.airbnbApp.repository;

import com.projects.airbnbApp.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
