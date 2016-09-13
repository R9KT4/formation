package com.etiennedesticourt.formation.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="computer")
public class Computer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private int companyId;
	@Column(name = "name")
	private String name;
	@Column(name = "introduced")
	private Timestamp introduced;
	@Column(name = "discontinued")
	private Timestamp discontinued;
	
	public String getName(){
		return name;
	}
	

}
