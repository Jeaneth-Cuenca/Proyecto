package com.proyecto.proyecto.Repository;

import com.proyecto.proyecto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
