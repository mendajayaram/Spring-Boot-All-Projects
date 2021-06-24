package com.nt.jai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.jai.model.Student;
import com.nt.jai.repo.StudentRepository;
@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentRepository repo; //HAS-A
	@Override
	public Integer saveStudent(Student s) {
		// TODO Auto-generated method stub
		 return repo.save(s).getStdId();
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Optional<Student> getOneStudent(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);

	}

	@Override
	public boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);

	}

}
