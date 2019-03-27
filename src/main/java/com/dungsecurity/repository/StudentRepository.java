package com.dungsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungsecurity.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
}
