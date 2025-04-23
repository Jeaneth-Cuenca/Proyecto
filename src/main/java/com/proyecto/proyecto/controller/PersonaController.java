package com.proyecto.proyecto.controller;
import com.proyecto.proyecto.model.Persona;
import org.springframework.web.bind.annotation.*;

        import java.util.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private Map<Long, Persona> personas = new HashMap<>();
    private long currentId = 1;

    @PostMapping
    public Persona registrarPersona(@RequestBody Persona persona) {
        persona.setId(currentId++);
        personas.put(persona.getId(), persona);
        return persona;
    }

    @GetMapping
    public Collection<Persona> listarPersonas() {
        return personas.values();
    }

    @GetMapping("/{id}")
    public Persona obtenerPersona(@PathVariable Long id) {
        return personas.get(id);
    }
}