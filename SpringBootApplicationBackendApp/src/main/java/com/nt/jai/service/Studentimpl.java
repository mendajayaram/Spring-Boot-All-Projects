package com.nt.jai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.jai.exception.StudentNotFoundException;
import com.nt.jai.model.Student10;
import com.nt.jai.repo.StudentRepo;
@Service
public class Studentimpl implements Istudent {
@Autowired
	private StudentRepo srepo;
	
	@Override
	public Integer savestudent(Student10 student) {
		
	Integer id=	srepo.save(student).getId();
		return id;
	}

	@Override
	public List<Student10> getallstuddents() {
		// TODO Auto-generated method stub
		return srepo.findAll();
	}

	@Override
	public Student10 getonestudent(Integer id) {
	Optional<Student10> opt = srepo.findById(id);
	
	Student10 std=opt.orElseThrow(()-> new  StudentNotFoundException("Student Not Exist"));
	
	
	/*
	 * //Student std=null; if(opt.isPresent()) { opt.get(); } else { throw new
	 * StudentNotFoundException("Student Not Exist"); }
	 */
	
	return std;
	}
	
	@Override
	public void deletestudent(Integer id) {
		
		Student10 std=getonestudent(id);
		srepo.delete(std);
	}

}
