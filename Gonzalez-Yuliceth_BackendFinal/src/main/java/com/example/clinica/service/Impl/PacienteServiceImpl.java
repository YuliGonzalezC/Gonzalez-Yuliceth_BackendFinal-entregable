package com.example.clinica.service.Impl;

import com.example.clinica.model.entity.Paciente;
import com.example.clinica.model.repository.PacienteRepository;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;
    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }


    @Override
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }


    @Override
    public Optional<Paciente> buscarPaciente(Long id) {
        return pacienteRepository.findById(id);
    }


    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
       return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
