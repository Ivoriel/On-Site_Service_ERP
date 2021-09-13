package pl.kosinski.serviceTask;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kosinski.serviceRequest.ServiceRequest;
import pl.kosinski.unit.Unit;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
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
