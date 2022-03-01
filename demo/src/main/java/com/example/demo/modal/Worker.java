package com.example.demo.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="workers")
@Data
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id ;
	
	@Column(name="first_name")
	String firstName ;
	
	@Column(name="last_name")
	String lastName ;
	
	@Column(name="email")
	String email ;
	
}
