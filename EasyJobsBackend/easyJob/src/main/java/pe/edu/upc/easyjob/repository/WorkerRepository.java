package pe.edu.upc.easyjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.easyjob.entity.Worker;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
    @Query("SELECT t FROM Worker t JOIN FETCH t.ocupaciones")
    List<Worker> findAllWithOcupaciones();
}
