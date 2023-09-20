package pe.edu.upc.easyjob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.easyjob.entity.Worker;
import pe.edu.upc.easyjob.interfaceservice.WorkerService;
import pe.edu.upc.easyjob.repository.WorkerRepository;

import java.util.List;
@Service
public class WorkerImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;


    @Override
    public Worker register(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public List<Worker> listWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker updateWorker(Worker worker) throws Exception {

         workerRepository.findById(worker.getId()).
                orElseThrow( ()-> new Exception("No se encontró trabajador"));

         return workerRepository.save(worker);
    }

    @Override
    public Worker deleteWorker(Long id) throws Exception {
        Worker worker = workerRepository.findById(id).
                orElseThrow( ()-> new Exception("No se encontró trabajador"));
        workerRepository.delete(worker);
        return worker;
    }

    @Override
    public Worker getWorkerById(Long id) throws Exception {
        Worker worker = workerRepository.findById(id).
                orElseThrow(()-> new Exception("No se encontró trabajador"));

        return worker;
    }

    @Override
    public List<Worker> obtenerTrabajadoresConOcupaciones() {
        return workerRepository.findAllWithOcupaciones();
    }
}
