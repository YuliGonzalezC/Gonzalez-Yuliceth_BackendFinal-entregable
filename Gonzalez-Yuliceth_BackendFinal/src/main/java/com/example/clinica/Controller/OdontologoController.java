package com.example.clinica.Controller;

import com.example.clinica.model.entity.Odontologo;
import com.example.clinica.service.Impl.OdontologoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final OdontologoServiceImpl odontologoService;

    @Autowired
    public OdontologoController(OdontologoServiceImpl odontologoService){
        this.odontologoService = odontologoService;
    }


    @PostMapping()
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.registrarOdontologo(odontologo));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) {
        Odontologo odontologo = odontologoService.buscarOdontologo((id)).orElse(null);

        return ResponseEntity.ok(odontologo);
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        ResponseEntity<Odontologo> response = null;

        if (odontologo.getId() != null && odontologoService.buscarOdontologo(odontologo.getId()).isPresent())
            response = ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) {
        ResponseEntity<String> response = null;

        if (odontologoService.buscarOdontologo(id).isPresent()) {
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologo(){
        return ResponseEntity.ok(odontologoService.listarOdontologo());
    }




}
