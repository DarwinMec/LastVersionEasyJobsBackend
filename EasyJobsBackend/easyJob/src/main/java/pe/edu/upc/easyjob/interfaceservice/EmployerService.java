package pe.edu.upc.easyjob.interfaceservice;

import pe.edu.upc.easyjob.entity.Employer;

import java.util.List;

public interface EmployerService {

    public Employer register(Employer employer);
    public List<Employer> listEmployers();

    public Employer updateEmployer(Employer employer) throws Exception;

    public Employer deleteEmployer(Long id) throws Exception;

}
