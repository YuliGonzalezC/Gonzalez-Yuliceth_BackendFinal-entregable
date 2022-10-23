package com.example.clinica.service;
import com.example.clinica.dto.DomicilioDTO;
import com.example.clinica.model.entity.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {


    Optional<DomicilioDTO> buscar(Long id);
    List<DomicilioDTO> buscarTodos();
    void eliminar(Long id);
    DomicilioDTO actualizar(DomicilioDTO domicilioDto);

    Domicilio registrar(DomicilioDTO domicilioDTO);
}
