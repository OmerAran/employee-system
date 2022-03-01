package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}