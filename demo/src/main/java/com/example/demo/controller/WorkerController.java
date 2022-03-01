package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.Worker;
import com.example.demo.repository.WorkerRepository;


@RestController
@RequestMapping("/api/")
public class WorkerController {
	
	@Autowired
	private WorkerRepository workerRepository ;

	@GetMapping("/workers")
	public List<Worker> getAllWorkers(){
		return workerRepository.findAll();
		
	}
	
	
	
	
	
	
	
	
}
