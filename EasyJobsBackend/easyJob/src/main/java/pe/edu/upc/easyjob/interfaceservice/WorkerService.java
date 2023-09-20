package pe.edu.upc.easyjob.interfaceservice;

import pe.edu.upc.easyjob.entity.Worker;

import java.util.List;

public interface WorkerService {

    public Worker register(Worker worker);

    public List<Worker> listWorkers();

    public  Worker updateWorker(Worker worker) throws Exception;

    public Worker deleteWorker(Long id) throws Exception;

    public Worker getWorkerById(Long id) throws  Exception;

    public List<Worker> obtenerTrabajadoresConOcupaciones();

}
