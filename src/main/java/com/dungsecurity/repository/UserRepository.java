package com.dungsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dungsecurity.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserName(String name);
}
