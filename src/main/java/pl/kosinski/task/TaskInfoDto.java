package pl.kosinski.task;

import lombok.Data;
import pl.kosinski.common.TaskStatus;
import pl.kosinski.request.Request;
import pl.kosinski.unit.Unit;

@Data
public class TaskInfoDto {

    private Long id;
    private Request request;
    private Unit unit;
    private TaskStatus status;
    private String description;
    private Integer workTime;
}
