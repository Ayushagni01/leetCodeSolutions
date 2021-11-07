package com.location.web.flight.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//this class is not directly mapped with database
@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //automatically generated
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
