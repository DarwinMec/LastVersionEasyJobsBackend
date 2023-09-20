package pe.edu.upc.easyjob.dto;

import lombok.Data;

@Data
public class EmployerDTO {

    private Long id;
    private String nameEmployer;
    private int age_employer;
    private String city_employer;
    private int phone_employer;
    private String email_employer;
}
