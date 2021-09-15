package pl.kosinski.task;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private String description;
}