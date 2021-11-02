package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.modelo.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{

}
