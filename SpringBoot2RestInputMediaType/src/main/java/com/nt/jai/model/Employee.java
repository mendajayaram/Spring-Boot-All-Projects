package com.nt.jai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Integer eid;
	private String ename;
	private Double esal;
	private Double hra;
	private Double ta;

}
