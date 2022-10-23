package com.example.clinica.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TurnoDTO {
    private Long id;
    private Date fecha;
    private PacienteDTO pacienteDto;
    private OdontologoDTO odontologoDto;
}
