package com.example.clinica.model.repository;


import com.example.clinica.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PacienteRepository extends JpaRepository<Paciente, Long> {


}
