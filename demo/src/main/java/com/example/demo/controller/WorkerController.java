package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.SourceNotFoundException;
import com.example.demo.modal.Worker;
import com.example.demo.repository.WorkerRepository;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/")
public class WorkerController {
	
	@Autowired
	private WorkerRepository workerRepository ;

	@GetMapping("workers")
	public List<Worker> getAllWorkers(){
		return workerRepository.findAll();
		
	}
	@PostMapping("workers")
	public Worker createWorker(@RequestBody Worker worker) {
		
		return workerRepository.save(worker)	 ;	
		
	}
	
	@GetMapping("workers/{id}")
	public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
		Worker worker = workerRepository.findById(id).
				orElseThrow(()-> new SourceNotFoundException("Worker didn't found who has this id : )"+id));
		return ResponseEntity.ok(worker);
		
		
	}
	
	@PutMapping("workers/{id}")
	public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker workerDetails) {
		
		Worker worker = workerRepository.findById(id).
				orElseThrow(()-> new SourceNotFoundException("Worker didn't found who has this id : )"+id));
		
		worker.setFirstName(workerDetails.getFirstName());
		worker.setLastName(workerDetails.getLastName()); 
		worker.setEmail(workerDetails.getEmail());
		Worker updatedWorker = workerRepository.save(worker);
		
		return ResponseEntity.ok(updatedWorker);
		
	}
	
	
	@DeleteMapping("workers/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteWorker(@PathVariable Long id) {
		Worker worker = workerRepository.findById(id).
				orElseThrow(()-> new SourceNotFoundException("Worker didn't found who has this id : )"+id));
		 workerRepository.delete(worker);
		 Map<String,Boolean> response = new HashMap<>();
		 response.put("deleted", Boolean.TRUE);
		 return ResponseEntity.ok(response);
		 
	}
	
	
	
	
	
	
}
