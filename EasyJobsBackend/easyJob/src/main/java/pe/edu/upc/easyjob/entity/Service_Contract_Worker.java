package pe.edu.upc.easyjob.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.easyjob.keys.Service_Contract_Worker_Id;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_contract_worker")
public class Service_Contract_Worker {
    @EmbeddedId
    private Service_Contract_Worker_Id id;

    @Column(name = "monto")
    private double monto;

}
