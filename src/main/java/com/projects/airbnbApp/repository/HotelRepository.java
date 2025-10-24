package com.projects.airbnbApp.repository;

import com.projects.airbnbApp.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
