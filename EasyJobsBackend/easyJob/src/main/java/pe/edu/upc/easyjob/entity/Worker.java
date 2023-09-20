package pe.edu.upc.easyjob.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_worker", length = 50, nullable = false)
    private String name_worker;

    @Column(name = "age_worker", nullable = false)
    private int age_worker;

    @Column(name = "address_worker", length = 50, nullable = false)
    private String address_worker;

    @Column(name = "email_worker", length = 50, nullable = false)
    private String email_worker;

    @Column(name = "phone_worker", nullable = false)
    private int phone_worker;

    @Column(name = "city_worker", nullable = false)
    private String city_worker;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "trabajador_ocupacion",
            joinColumns = @JoinColumn(name = "trabajador_id"),
            inverseJoinColumns = @JoinColumn(name = "ocupacion_id")
    )
    private List<Occupation> ocupaciones;

}
