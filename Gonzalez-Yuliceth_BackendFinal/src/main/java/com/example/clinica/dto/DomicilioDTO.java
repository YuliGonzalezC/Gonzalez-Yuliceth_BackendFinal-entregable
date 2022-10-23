package com.example.clinica.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//jsonignore ?
public class DomicilioDTO {

    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;
    private PacienteDTO pacienteDto;
}
