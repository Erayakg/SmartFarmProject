package com.example.TarimAraziProject.repositories;

import com.example.TarimAraziProject.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
