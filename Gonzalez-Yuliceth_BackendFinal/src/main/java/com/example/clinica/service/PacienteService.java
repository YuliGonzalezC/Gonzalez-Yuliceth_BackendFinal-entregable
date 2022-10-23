package com.example.clinica.service;

import com.example.clinica.model.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    List<Paciente> listarPacientes();
    Optional<Paciente> buscarPaciente(Long id);
    Paciente guardarPaciente(Paciente paciente);
    Paciente actualizarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
}
