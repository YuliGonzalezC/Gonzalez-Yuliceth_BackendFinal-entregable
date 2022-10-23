package com.example.clinica.service;

import com.example.clinica.model.entity.Turno;

import java.util.List;
import java.util.Optional;


public interface TurnoService {

    List<Turno> listarTurnos();
    Optional<Turno> buscarTurno(Long id);
   Turno guardaTurno (Turno turno);
    Turno actualizarTurno(Turno turno);
    void eliminarTurno(Long id);

}
