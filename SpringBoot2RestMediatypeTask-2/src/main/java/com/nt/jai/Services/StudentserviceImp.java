package com.nt.jai.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.jai.Repo.StudentRepository;

import com.nt.jai.model.Student;

@Service
public class StudentserviceImp implements IStudentService {
	@Autowired
private StudentRepository srepo;

	@Override
	public Integer SavaStudent(Student student) {
		
		student.setSid(1);
			student=srepo.save(student);

			return student.getSid();
			
	}

}
