package com.example.clinica.service.Impl;

import com.example.clinica.dto.DomicilioDTO;
import com.example.clinica.model.entity.Domicilio;
import com.example.clinica.model.repository.DomicilioRepository;
import com.example.clinica.service.DomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public DomicilioServiceImpl(DomicilioRepository domicilioRepository) {
        this.domicilioRepository= domicilioRepository;
    }



    @Override
    public Optional<DomicilioDTO> buscar(Long id) {
        Optional<Domicilio> domicilio = domicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent()) {
            domicilioDTO = mapper.convertValue(domicilio, DomicilioDTO.class);

        }
        return Optional.ofNullable(domicilioDTO);
    }

    @Override
    public List<DomicilioDTO> buscarTodos() {
            List <Domicilio> listaDomicilios=domicilioRepository.findAll();
            List <DomicilioDTO> listaDomiciliosDTO= new ArrayList<>();
            for(Domicilio domicilio:listaDomicilios){
                listaDomiciliosDTO.add( mapper.convertValue(domicilio,DomicilioDTO.class));

            }
            return listaDomiciliosDTO;
        }


    @Override
    public void eliminar(Long id) {domicilioRepository.deleteById(id);
    }

    @Override
    public DomicilioDTO actualizar(DomicilioDTO domicilioDto) {
        Domicilio domicilio=mapper.convertValue(domicilioDto,Domicilio.class) ;
        domicilioRepository.save(domicilio);
        return domicilioDto;
    }

    @Override
    public Domicilio registrar(DomicilioDTO domicilioDTO) {
        Domicilio domicilio=mapper.convertValue(domicilioDTO,Domicilio.class) ;
        return domicilioRepository.save(domicilio);
    }
}
