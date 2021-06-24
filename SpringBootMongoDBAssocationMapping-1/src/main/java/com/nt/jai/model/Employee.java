package com.nt.jai.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	private Integer empId;
	private String empName;
	private Double empSal;
    private Set<String>empproj;
    private List<String>empprojver;
    private String[] empGrades;
    private Map<String,String>empclient;
    private Address add;
    private List<Department> dobs;
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
