package pl.kosinski.unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kosinski.client.Client;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;
    @NotNull
    private String serialNumber;
    @ManyToOne
    @NotNull
    private Client client;

    public void setUnitInfo(String serialNumber, Client client) {
        this.serialNumber = serialNumber;
        this.client = client;
    }

}
