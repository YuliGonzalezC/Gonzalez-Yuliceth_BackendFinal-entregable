package com.example.clinica.Controller;

import com.example.clinica.dto.DomicilioDTO;
import com.example.clinica.service.Impl.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/domicilios")
public class DomicilioController {



    // implementacion!!
    @Autowired
    DomicilioServiceImpl domicilioService;

    @GetMapping
    public ResponseEntity<List<DomicilioDTO>> listarDomicilios() {
        return ResponseEntity.ok(domicilioService.buscarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO> buscarDomicilio(@PathVariable Long id) {
        DomicilioDTO domicilioDTO = domicilioService.buscar(id).orElse(null);
        if(domicilioDTO == null)
        { return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
        else
        {return ResponseEntity.ok(domicilioDTO);}
    }



    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarDomicilio(@PathVariable Long id) {
        Optional<DomicilioDTO> domicilioEncontrado= domicilioService.buscar(id);
        if(domicilioEncontrado.isPresent()){
            domicilioService.eliminar(id);
            return ResponseEntity.ok("Domicilio con id "+id+" eliminado");} else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body
                    ("No se encontro domicilio con id "+id);
        }

    }

    @PutMapping("/actualizar")
    public ResponseEntity<DomicilioDTO> actualizarDomicilio(@RequestBody DomicilioDTO domicilioDTO) {
        Optional<DomicilioDTO> domicilioDto= domicilioService.buscar(domicilioDTO.getId());
        if(domicilioDTO != null && domicilioDto.isPresent()){
            return ResponseEntity.ok( domicilioService.actualizar(domicilioDTO));}
        else{ return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
    }



}
