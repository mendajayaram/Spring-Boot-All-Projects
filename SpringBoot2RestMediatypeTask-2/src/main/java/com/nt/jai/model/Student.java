package com.nt.jai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	private String sname;
	private double sfee;
	private String address;
	
}
