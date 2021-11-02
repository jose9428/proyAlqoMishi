package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.modelo.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
	
}
