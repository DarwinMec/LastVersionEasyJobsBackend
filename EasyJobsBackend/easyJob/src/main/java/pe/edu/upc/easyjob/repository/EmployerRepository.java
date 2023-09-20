package pe.edu.upc.easyjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.easyjob.entity.Employer;
import pe.edu.upc.easyjob.entity.Worker;

import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employer,Long> {

}
