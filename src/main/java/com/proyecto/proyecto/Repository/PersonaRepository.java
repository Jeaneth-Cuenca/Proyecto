package com.proyecto.proyecto.Repository;

import com.proyecto.proyecto.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
