package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.modelo.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}
