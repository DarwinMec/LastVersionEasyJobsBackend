package pe.edu.upc.easyjob.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_type")
public class Service_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_service_type",length = 50, nullable = false)
    private String name_service_type;

    @Column(name = "desc_service_type",length = 50, nullable = false)
    private String desc_service_type;
}
