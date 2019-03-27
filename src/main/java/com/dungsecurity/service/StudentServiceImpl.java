package com.dungsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dungsecurity.entity.StudentEntity;
import com.dungsecurity.repository.StudentRepository;

@Service
public class StudentServiceImpl {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<StudentEntity> findAllStudent(String name){
		return studentRepository.findAll();
	}
}
