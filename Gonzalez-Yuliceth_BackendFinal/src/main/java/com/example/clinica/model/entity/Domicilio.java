package com.example.clinica.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table (name = "domicilios")
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="domicilio_sequence" )
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    // le doy la clave foranea // su elimino el paciente elimino al domicilio cascadeall
    @OneToOne(mappedBy= "domicilio",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Paciente paciente;
}
