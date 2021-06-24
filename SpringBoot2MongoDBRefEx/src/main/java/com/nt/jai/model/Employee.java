package com.nt.jai.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Employee {
	@Id
	private Integer eid;
	private String ename;
	private Double esal;
	//*...1@DBRef
	private Department dob; 
	//*...*
	@DBRef
	private List<Project> pobs;

}
