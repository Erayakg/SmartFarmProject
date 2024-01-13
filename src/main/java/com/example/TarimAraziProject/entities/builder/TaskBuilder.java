package com.example.TarimAraziProject.entities.builder;

import com.example.TarimAraziProject.entities.*;

import java.time.LocalDateTime;

public class TaskBuilder {

    private String name;
    private Boolean statement;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Farm farm;
    private Fertilization fertilization;
    private Harvesting harvesting;
    private Irrigate irrigate;
    private Planting planting;

    private TaskBuilder() {

    }

    public static TaskBuilder aTask() {
        return new TaskBuilder();
    }

    public TaskBuilder withPlanting(Planting planting) {
        this.planting = planting;
        return this;
    }
    public TaskBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TaskBuilder withStatement(Boolean statement) {
        this.statement = statement;
        return this;
    }

    public TaskBuilder withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public TaskBuilder withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public TaskBuilder withFarm(Farm farm) {
        this.farm = farm;
        return this;
    }

    public TaskBuilder withFertilization(Fertilization fertilization) {
        this.fertilization = fertilization;
        return this;
    }

    public TaskBuilder withHarvesting(Harvesting harvesting) {
        this.harvesting = harvesting;
        return this;
    }

    public TaskBuilder withIrrigate(Irrigate irrigate) {
        this.irrigate = irrigate;
        return this;
    }

    public Task build() {
        Task task = new Task();

        task.setName(name);
        task.setStatement(statement);
        task.setStartDate(LocalDateTime.now());
        task.setEndDate(endDate);
        task.setFarm(farm);
        task.setFertilization(fertilization);
        task.setHarvesting(harvesting);
        task.setIrrigate(irrigate);
        task.setPlanting(planting);
        return task;
    }

    public Task buildWithFertilization() {
        Task task = new Task();
        task.setName(name);
        task.setStatement(statement);
        task.setEndDate(LocalDateTime.now().plusDays(3));
        task.setFarm(farm);
        task.setFertilization(fertilization);
        return task;
    }
    public Task buildWithPlanting() {
        Task task = new Task();
        task.setName(name);
        task.setStatement(statement);
        task.setEndDate(LocalDateTime.now().plusDays(3));
        task.setFarm(farm);
        task.setPlanting(planting);
        return task;
    }

    public Task buildWithHarvesting() {
        Task task = new Task();

        task.setName(name);
        task.setStatement(statement);
        task.setEndDate(LocalDateTime.now().plusDays(10));
        task.setFarm(farm);
        task.setHarvesting(harvesting);
        return task;
    }

    public Task buildWithIrrigate() {
        Task task = new Task();
        task.setName(name);
        task.setStatement(statement);
        task.setEndDate(LocalDateTime.now().plusDays(1));
        task.setFarm(farm);
        task.setIrrigate(irrigate);
        return task;
    }
}


