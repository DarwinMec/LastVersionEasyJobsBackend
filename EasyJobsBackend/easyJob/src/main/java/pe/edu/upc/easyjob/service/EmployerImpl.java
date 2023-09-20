package pe.edu.upc.easyjob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.easyjob.entity.Employer;
import pe.edu.upc.easyjob.interfaceservice.EmployerService;
import pe.edu.upc.easyjob.repository.EmployerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    //registrar empleado
    public Employer register(Employer employer) { return  employerRepository.save(employer); }

    /* Listar todos los empleadores*/
    public List<Employer> listEmployers() { return employerRepository.findAll(); }

    public Employer updateEmployer(Employer employer) throws Exception{
        employerRepository.findById(employer.getId()).
                orElseThrow( ()-> new Exception("No se encontro empleador") );
        return employerRepository.save(employer);
    }

    public Employer deleteEmployer(Long id) throws Exception{
        Employer employer = employerRepository.findById(id).
                orElseThrow( ()-> new Exception("no se encontró empleador"));

        employerRepository.delete(employer);
        return employer;
    }



}
