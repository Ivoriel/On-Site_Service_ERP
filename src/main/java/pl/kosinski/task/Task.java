package pl.kosinski.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kosinski.common.TaskStatus;
import pl.kosinski.request.Request;
import pl.kosinski.unit.Unit;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Request request;
    @OneToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private String description;

    public void setTaskInfo(Request request, Unit unit, String description) {
        this.request = request;
        this.unit = unit;
        this.description = description;
    }
}
