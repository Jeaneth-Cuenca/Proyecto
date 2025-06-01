package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Habitacion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {

    private static final Logger logger = LoggerFactory.getLogger(HabitacionController.class);
    private final List<Habitacion> habitaciones = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Habitacion> crearHabitacion(@RequestBody Habitacion nueva) {
        if (nueva.getNumero() <= 0 || nueva.getTipo() == null || nueva.getCapacidad() <= 0) {
            logger.error("Datos inválidos para la habitación: {}", nueva);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        habitaciones.add(nueva);
        logger.info("Habitación creada: {}", nueva);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Habitacion>> obtenerTodas() {
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }
}