package pe.edu.upc.easyjob.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;
import java.util.Set;

@Data
public class WorkerDTO {
    private long id;
    private String name_worker;
    private int age_worker;
    private String address_worker;
    private String email_worker;
    private int phone_worker;
    private String city_worker;
    private List<String> nombresOcupaciones;
}
