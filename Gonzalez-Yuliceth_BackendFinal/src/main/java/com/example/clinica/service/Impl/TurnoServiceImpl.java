package com.example.clinica.service.Impl;


import com.example.clinica.model.entity.Turno;
import com.example.clinica.model.repository.TurnoRepository;
import com.example.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {

    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository= turnoRepository;
    }


    @Override
    public List<Turno> listarTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> buscarTurno(Long id) {
        return turnoRepository.findById(id);
    }

    @Override
    public Turno guardaTurno(Turno turno) {
       return turnoRepository.save(turno);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }
}
