package com.service.veterinario.controller;

import org.springframework.web.bind.annotation.RestController;

import com.service.veterinario.model.Veterinario;
import com.service.veterinario.service.VeterinarioService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/v1/propietarios")
public class VeterinarioController {
    @Autowired
    private VeterinarioService veterinarioService;


    @GetMapping
    public ResponseEntity<List<Veterinario>> listar() {
        List<Veterinario> veterinarios = veterinarioService.findAll();
        if (veterinarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(veterinarios);
    }

    @PostMapping()
    public ResponseEntity<Veterinario> guardar(@RequestBody Veterinario veterinario){
        Veterinario nuevo = veterinarioService.save(veterinario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscar(@PathVariable Integer id) {
        try {
            Veterinario veterinario = veterinarioService.findById(id);
            return ResponseEntity.ok(veterinario);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> actualizar(@PathVariable Integer id, @RequestBody Veterinario veterinario) {
        try {
            Veterinario existente = veterinarioService.findById(id);
            existente.setId(id);
            existente.setNombre(existente.getNombre());
            existente.setApellido(existente.getApellido());
            existente.setEmail(existente.getEmail());

            Veterinario actualizado = veterinarioService.save(existente);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            veterinarioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
