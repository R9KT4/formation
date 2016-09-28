package com.etiennedesticourt.formation.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="computer")
public class Computer {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne(targetEntity = Company.class)
	private Company company;
	@Column(name = "name")
	private String name;
	@Column(name = "introduced")
	private Timestamp introduced;
	@Column(name = "discontinued")
	private Timestamp discontinued;
	
	public String getName(){
		return name;
	}
	
	public Timestamp getIntroduced(){
		return introduced;
	}
	
	public Timestamp getDiscontinued(){
		return discontinued;
	}
	
	public String getCompanyName(){
		if (company != null) {
			return company.getName();
		}
		return null;
	}
}
