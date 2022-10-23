package com.example.clinica.service;

import com.example.clinica.model.entity.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    Odontologo registrarOdontologo(Odontologo odontologo);

    List<Odontologo> listarOdontologo();
    Optional<Odontologo> buscarOdontologo(Long id);

    Odontologo actualizarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);


}
