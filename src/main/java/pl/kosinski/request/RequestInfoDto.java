package pl.kosinski.request;

import lombok.Data;
import pl.kosinski.client.Client;
import pl.kosinski.common.RequestStatus;
import pl.kosinski.common.RequestType;
import pl.kosinski.task.Task;
import pl.kosinski.unit.Unit;

import java.util.List;

@Data
public class RequestInfoDto {

    private Long id;
    private Client client;
    private RequestType type;
    private RequestStatus status;
    private String brief;
    private String debrief;
    private List<Unit> units;
    private List<Task> tasks;
    private Integer workTime;
}
