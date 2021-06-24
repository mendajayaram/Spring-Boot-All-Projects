package com.nt.jai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Student10 {
@Id
@GeneratedValue
	private Integer id;
	private String sname;
	private String sbranch;
	private String saddress;
	private Long phno;
	private Double sfee;
}
