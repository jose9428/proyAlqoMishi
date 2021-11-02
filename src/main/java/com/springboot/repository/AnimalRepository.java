package com.springboot.repository;




import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.modelo.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	@Transactional
	@Query(value = "{call usp_filtrar_especie(:esp)}", nativeQuery =true)
	public Optional<Animal> listaProcedure(@Param("esp") int esp);
}