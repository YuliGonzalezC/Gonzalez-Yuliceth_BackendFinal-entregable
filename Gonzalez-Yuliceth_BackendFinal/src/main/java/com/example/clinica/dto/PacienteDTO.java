package com.example.clinica.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    private DomicilioDTO domicilioDto;
    // los turnos van en el dto ?
    private Set<TurnoDTO> turnosDto= new HashSet<>();
}
