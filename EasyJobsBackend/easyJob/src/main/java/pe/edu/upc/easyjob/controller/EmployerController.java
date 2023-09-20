package pe.edu.upc.easyjob.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.easyjob.dto.EmployerDTO;
import pe.edu.upc.easyjob.entity.Employer;
import pe.edu.upc.easyjob.interfaceservice.EmployerService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    Logger logger = LoggerFactory.getLogger(EmployerController.class);

    @PostMapping("/registerEmployer")
    ResponseEntity<EmployerDTO> register(@RequestBody EmployerDTO employerDTO){
        Employer employer;
        EmployerDTO dto;

        try {
            employer = convertToEntity(employerDTO);
            employer = employerService.register(employer);
            dto = convertToDTO(employer);
        }catch (Exception e){
            logger.error(e.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
        }

        return new ResponseEntity<EmployerDTO>(dto,HttpStatus.OK);
    }

    @GetMapping("/")
    ResponseEntity<List<EmployerDTO>> listEmployers(){
        List<Employer> list;
        List<EmployerDTO> listDTO = null;

        try{
            list = employerService.listEmployers();
            listDTO = convertToListDto(list);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lista no disponible");
        }

        return new ResponseEntity<>(listDTO,HttpStatus.OK);
    }


    private Employer convertToEntity(EmployerDTO employerDTO){
        ModelMapper modelMapper = new ModelMapper();
        Employer post = modelMapper.map(employerDTO, Employer.class);
        return post;
    }

    private EmployerDTO convertToDTO(Employer employer){
        ModelMapper modelMapper = new ModelMapper();
        EmployerDTO employerDTO = modelMapper.map(employer,EmployerDTO.class);
        return  employerDTO;
    }

    private List<EmployerDTO> convertToListDto(List<Employer> list){
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }



}
