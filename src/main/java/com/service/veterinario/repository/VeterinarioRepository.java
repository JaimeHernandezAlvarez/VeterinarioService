package com.service.veterinario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.veterinario.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

}
