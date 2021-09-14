package pl.kosinski.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kosinski.client.Client;
import pl.kosinski.common.RequestStatus;
import pl.kosinski.common.RequestType;
import pl.kosinski.task.Task;
import pl.kosinski.unit.Unit;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    private Enum<RequestType> type;
    private Enum<RequestStatus> status;
    private String brief;
    private String debrief;
    @ManyToMany
    @JoinTable(name = "requests_units",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "unit_id"))
    private List<Unit> units = new ArrayList<>();
    @OneToMany(mappedBy = "request")
    private List<Task> tasks = new ArrayList<>();

    public void setRequestInfo(Client client, Enum<RequestType> type, Enum<RequestStatus> status, String brief) {
        this.client = client;
        this.type = type;
        this.status = status;
        this.brief = brief;
    }

    public void updateTasksAndUnits(List<Task> tasks, List<Unit> units) {
        this.tasks = tasks;
        this.units = units;
    }
}
