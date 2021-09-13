package pl.kosinski.serviceTask;

import pl.kosinski.serviceRequest.ServiceRequest;
import pl.kosinski.unit.Unit;

import javax.persistence.*;

@Entity
public class ServiceTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ServiceRequest serviceRequest;
    @OneToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
    private String description;
}
