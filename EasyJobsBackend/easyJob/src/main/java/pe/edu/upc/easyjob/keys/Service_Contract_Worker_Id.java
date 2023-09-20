package pe.edu.upc.easyjob.keys;

import pe.edu.upc.easyjob.entity.Service_Contract;
import pe.edu.upc.easyjob.entity.Worker;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class Service_Contract_Worker_Id implements Serializable {

    @ManyToOne
    @JoinColumn(name = "service_contract_id")
    private Service_Contract service_contract;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

}
