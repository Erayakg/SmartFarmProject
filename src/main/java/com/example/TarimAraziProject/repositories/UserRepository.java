package com.example.TarimAraziProject.repositories;

import com.example.TarimAraziProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
