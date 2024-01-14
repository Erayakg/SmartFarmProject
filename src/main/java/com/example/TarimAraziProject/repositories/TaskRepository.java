package com.example.TarimAraziProject.repositories;

import com.example.TarimAraziProject.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
