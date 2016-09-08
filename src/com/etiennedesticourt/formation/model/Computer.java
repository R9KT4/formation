package com.etiennedesticourt.formation.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="computer")
public class Computer {
	private int id;
	private int companyId;
	private String name;
	private Timestamp introduced;
	private Timestamp discontinued;

}
