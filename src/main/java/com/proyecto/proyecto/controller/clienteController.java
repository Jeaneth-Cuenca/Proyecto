package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Cliente;
import com.proyecto.proyecto.model.mensaje;
import com.proyecto.proyecto.Repository.ClienteRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Cliente", description = "Operaciones relacionadas con clientes")
public class clienteController {

    private static final Logger logger = LoggerFactory.getLogger(clienteController.class);
    private final ClienteRepository clienteRepository;

    public clienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Operation(summary = "Obtener todos los clientes")
    @ApiResponse(responseCode = "200", description = "Clientes obtenidos correctamente")
    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Obtener un cliente por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        logger.info("Buscando cliente con ID {}", id);
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(value -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Crear un nuevo cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        try {
            Cliente saved = clienteRepository.save(cliente);
            logger.info("Cliente creado con ID {}", saved.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            logger.error("Error al crear cliente", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Eliminar un cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente eliminado"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<mensaje> deleteCliente(@PathVariable Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return ResponseEntity.ok(new mensaje("Cliente eliminado correctamente", "success"));
        } else {
            logger.warn("No se encontró cliente con ID {}", id);
            return ResponseEntity.ok(new mensaje("Cliente no encontrado", "error"));
        }
    }

    @Operation(summary = "Actualizar completamente un cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente actualizado"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente updatedCliente) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            Cliente cliente = optional.get();
            cliente.setNombre(updatedCliente.getNombre());
            cliente.setGmail(updatedCliente.getGmail());
            cliente.setCelular(updatedCliente.getCelular());
            Cliente saved = clienteRepository.save(cliente);
            logger.info("Cliente actualizado con ID {}", id);
            return ResponseEntity.ok(saved);
        } else {
            logger.warn("No se encontró cliente con ID {} para actualizar", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Actualizar parcialmente un cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente actualizado parcialmente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> patchCliente(@PathVariable Long id, @RequestBody Cliente partialCliente) {
        Optional<Cliente> optional = clienteRepository.findById(id);
        if (optional.isPresent()) {
            Cliente cliente = optional.get();
            if (partialCliente.getNombre() != null) {
                cliente.setNombre(partialCliente.getNombre());
            }
            if (partialCliente.getGmail() != null) {
                cliente.setGmail(partialCliente.getGmail());
            }
            if (partialCliente.getCelular() != null) {
                cliente.setCelular(partialCliente.getCelular());
            }
            Cliente saved = clienteRepository.save(cliente);
            logger.info("Cliente parcialmente actualizado con ID {}", id);
            return ResponseEntity.ok(saved);
        } else {
            logger.warn("No se encontró cliente con ID {} para patch", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}