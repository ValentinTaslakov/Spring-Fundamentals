package com.example.demo.repositories;

import com.example.demo.models.entities.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {
}
