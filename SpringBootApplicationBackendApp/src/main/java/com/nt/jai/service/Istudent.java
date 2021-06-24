package com.nt.jai.service;

import java.util.List;

import com.nt.jai.model.Student10;

public interface Istudent {
	
	public Integer savestudent(Student10 student);
	
	public List<Student10> getallstuddents();
	
	public Student10 getonestudent(Integer id);
	
	public void deletestudent(Integer id);

}
