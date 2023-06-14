package com.rafael.demoapi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(nullable = false)
	private long id;
	
	@Column(length = 63, nullable = false)
	private String name;
	
	@Column(length = 255)
	private String email;
	
	@Column(length = 63)
	private String password;
	

}
