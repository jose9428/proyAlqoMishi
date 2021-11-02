package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.modelo.Adopcion;

@Repository
public interface AdopcionRepository extends JpaRepository<Adopcion, Integer>{

}
