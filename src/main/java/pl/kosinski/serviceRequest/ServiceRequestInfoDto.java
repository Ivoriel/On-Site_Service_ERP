package pl.kosinski.serviceRequest;

import lombok.Data;
import pl.kosinski.common.ServiceRequestStatus;
import pl.kosinski.common.ServiceRequestType;
import pl.kosinski.serviceTask.ServiceTask;
import pl.kosinski.unit.Unit;

import java.util.List;

@Data
public class ServiceRequestInfoDto {

    private Long id;
    private Enum<ServiceRequestType> type;
    private Enum<ServiceRequestStatus> status;
    private String brief;
    private String debrief;
    private List<Unit> units;
    private List<ServiceTask> tasks;
}
