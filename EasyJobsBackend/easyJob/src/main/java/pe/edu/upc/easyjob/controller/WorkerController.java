package pe.edu.upc.easyjob.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.easyjob.dto.EmployerDTO;
import pe.edu.upc.easyjob.dto.WorkerDTO;
import pe.edu.upc.easyjob.entity.Employer;
import pe.edu.upc.easyjob.entity.Occupation;
import pe.edu.upc.easyjob.entity.Worker;
import pe.edu.upc.easyjob.interfaceservice.WorkerService;
import pe.edu.upc.easyjob.repository.WorkerRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class WorkerController {

    @Autowired
    private WorkerService workerService;


    Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @PostMapping("/registerWorker")
    ResponseEntity<WorkerDTO> register(@RequestBody WorkerDTO workerDTO){
        Worker worker;
        WorkerDTO dto;

        try{
            worker = convertToEntity(workerDTO);
            worker = workerService.register(worker);
            dto = convertToDTO(worker);

        }catch (Exception e){
            logger.error(e.toString());
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"No se pudo registrar");
        }

        return new ResponseEntity<WorkerDTO>(dto,HttpStatus.OK);
    }

    @GetMapping("/getAllWorkers")
    ResponseEntity<List<WorkerDTO>> listWorkers(){
        List<Worker> workerList;
        List<WorkerDTO> listDTO = null;

        try {
            workerList = workerService.listWorkers();
            listDTO = convertToListDto(workerList);


        }catch (Exception e){
            logger.error(e.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al consultar trabajadores");
        }

        return new ResponseEntity<List<WorkerDTO>>(listDTO,HttpStatus.OK);

    }

    @GetMapping("/getWorker/{id}")
    ResponseEntity<WorkerDTO> getWorkerById(@PathVariable(value = "id") Long id){
        Worker worker;
        WorkerDTO workerDTO;

        try {
            worker = workerService.getWorkerById(id);
            workerDTO = convertToDTO(worker);

        }catch (Exception e){
            logger.error(e.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al consultar trabajador");
        }

        return new ResponseEntity<WorkerDTO>(workerDTO,HttpStatus.OK);

    }

    @PutMapping("/updateWorkerbyId")
    ResponseEntity<Worker> updateWorker(@RequestBody Worker worker){

        Worker worker1;

        try {
            worker1 = workerService.updateWorker(worker);
        }catch (Exception e){
            logger.error(e.toString());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error al actualizar trabajador");
        }

        return new ResponseEntity<Worker>(worker1,HttpStatus.OK);

    }


    @DeleteMapping("/worker/{id}")
    Worker delete(@PathVariable(value = "id") Long id){
        Worker worker;
        try{
            worker = workerService.deleteWorker(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar trabajador");
        }
        return worker ;
    }

    @GetMapping("/workeroccu")
    public ResponseEntity<List<WorkerDTO>> obtenerTrabajadoresConNombresOcupaciones() {
        try {
            List<Worker> workers = workerService.obtenerTrabajadoresConOcupaciones();

            // Mapea los resultados a TrabajadorDTO con los nombres de las ocupaciones
            List<WorkerDTO> trabajadoresDTO = workers.stream()
                    .map(worker -> {
                        ModelMapper modelMapper = new ModelMapper();
                        WorkerDTO dto = modelMapper.map(worker, WorkerDTO.class);
                        List<String> nombresOcupaciones = worker.getOcupaciones().stream()
                                .map(Occupation::getName_occupation)
                                .collect(Collectors.toList());
                        dto.setNombresOcupaciones(nombresOcupaciones);
                        return dto;
                    })
                    .collect(Collectors.toList());

            return new ResponseEntity<>(trabajadoresDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al obtener trabajadores con ocupaciones: {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private Worker convertToEntity(WorkerDTO workerDTO){
        ModelMapper modelMapper = new ModelMapper();
        Worker post = modelMapper.map(workerDTO, Worker.class);
        return post;
    }

    private WorkerDTO convertToDTO(Worker worker){
        ModelMapper modelMapper = new ModelMapper();
        WorkerDTO workerDTO = modelMapper.map(worker,WorkerDTO.class);
        return  workerDTO;
    }

    private List<WorkerDTO> convertToListDto(List<Worker> list){
        return list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
}
