package com.example.TarimAraziProject.repositories;

import com.example.TarimAraziProject.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
