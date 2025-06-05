package com.service.veterinario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.veterinario.model.Veterinario;
import com.service.veterinario.repository.VeterinarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VeterinarioService {
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    //Listar usuarios
    public List<Veterinario> findAll(){
        return veterinarioRepository.findAll();
    }

    //Listar usuario por ID
    public Veterinario findById(long id){
        return veterinarioRepository.findById(id).get();
    }

    //guardar usuario por ID
    public Veterinario save(Veterinario usuario){
        return veterinarioRepository.save(usuario);
    }

    //Eliminar usuario
    public void delete(long id){
        veterinarioRepository.deleteById(id);
    }
}
