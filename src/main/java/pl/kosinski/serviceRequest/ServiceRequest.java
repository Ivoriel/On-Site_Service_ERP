package pl.kosinski.serviceRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kosinski.client.Client;
import pl.kosinski.common.ServiceRequestStatus;
import pl.kosinski.common.ServiceRequestType;
import pl.kosinski.serviceTask.ServiceTask;
import pl.kosinski.unit.Unit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    private Enum<ServiceRequestType> type;
    private Enum<ServiceRequestStatus> status;
    private String brief;
    private String debrief;
    @ManyToMany
    @JoinTable(name = "service_requests_units",
            joinColumns = @JoinColumn(name = "service_request_id"),
            inverseJoinColumns = @JoinColumn(name = "unit_id"))
    private List<Unit> units = new ArrayList<>();
    @OneToMany(mappedBy = "serviceRequest")
    private List<ServiceTask> serviceTasks = new ArrayList<>();

    public void setRequestInfo(Client client, Enum<ServiceRequestType> type, Enum<ServiceRequestStatus> status, String brief) {
        this.client = client;
        this.type = type;
        this.status = status;
        this.brief = brief;
    }

    public void updateTasksAndUnits(List<ServiceTask> tasks, List<Unit> units) {
        this.serviceTasks = tasks;
        this.units = units;
    }
}
