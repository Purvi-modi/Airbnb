package com.projects.airbnbApp.repository;

import com.projects.airbnbApp.entity.Inventory;
import com.projects.airbnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    void deleteByDateAfterAndRoom(LocalDate date, Room room);
}
