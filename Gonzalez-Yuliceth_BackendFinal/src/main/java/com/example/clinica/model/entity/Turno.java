package com.example.clinica.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @SequenceGenerator(name = "turno_sequence",sequenceName = "turno_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "turno_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "odontologo_id")
    private Odontologo odontologo;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @Column
    private LocalDate fecha;

}
