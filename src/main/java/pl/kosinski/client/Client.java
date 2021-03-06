package pl.kosinski.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kosinski.unit.Unit;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @OneToMany(mappedBy = "client")
    private List<Unit> unitList = new ArrayList<>();

    public void setName(String name){
        this.name = name;
    }
}
