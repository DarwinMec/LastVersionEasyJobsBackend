package pe.edu.upc.easyjob.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employer")
public class Employer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_employer", length = 50, nullable = false)
    private String nameEmployer;

    @Column(name = "age_employer", nullable = false)
    private int age_employer;

    @Column(name = "city_employer", length = 50, nullable = false)
    private String city_employer;

    @Column(name = "phone_employer", nullable = false)
    private int phone_employer;

    @Column(name = "email_employer", length = 50, nullable = false)
    private String email_employer;


}
