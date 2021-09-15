package pl.kosinski.task;

import lombok.Data;
import pl.kosinski.request.Request;
import pl.kosinski.unit.Unit;

@Data
public class TaskInfoDto {

    private Long id;
    private Request request;
    private Unit unit;
    private String description;
}
