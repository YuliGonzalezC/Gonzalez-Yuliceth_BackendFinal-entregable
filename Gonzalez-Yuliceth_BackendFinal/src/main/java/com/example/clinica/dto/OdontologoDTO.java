package com.example.clinica.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OdontologoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private  String matricula;
    private Set<TurnoDTO> turnosDto = new HashSet<>();
}
