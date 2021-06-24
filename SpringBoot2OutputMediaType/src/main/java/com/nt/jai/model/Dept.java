package com.nt.jai.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
	private Integer did;
	private String dname;
	private String dcode;
	//Has Relation of employee Object
	private List<Employee> emps;
	//Has Relation of CompanyInfo Object
	private CompanyInfo cob;
}
