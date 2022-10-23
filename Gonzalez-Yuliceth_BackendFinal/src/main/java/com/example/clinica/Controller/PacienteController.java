package com.example.clinica.Controller;
import com.example.clinica.exceptions.ResourceNotFoundException;
import com.example.clinica.model.entity.Paciente;
import com.example.clinica.service.Impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/pacientes")
    public class PacienteController {

    private final PacienteServiceImpl pacienteService;

    @Autowired
    public PacienteController(PacienteServiceImpl pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> registrarNuevoPaciente(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.guardarPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> traerPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }


    @PutMapping
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente) {
        Optional<Paciente> pacienteParaActualizar = pacienteService.buscarPaciente(paciente.getId());
        if (pacienteParaActualizar.isPresent()) {
            return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteABorrar = pacienteService.buscarPaciente(id);
        if (pacienteABorrar.isPresent()) {
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se eliminó al paciente con ID=" + id);
        } else {
            //estoy en el caso de no encontrar el ID en la base de datos
            throw new ResourceNotFoundException("No se encontró al paciente con " +
                    "id=" + id + " para realizar su eliminación. Error al ingresar el ID");


        }

    }
}
