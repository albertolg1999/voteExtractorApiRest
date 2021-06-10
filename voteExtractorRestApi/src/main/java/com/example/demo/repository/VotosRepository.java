package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;
import com.example.demo.model.Votos;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotosRepository extends JpaRepository<Votos, Integer> {
	Votos findByNombre (@Param("nombre") String nombre);

}
