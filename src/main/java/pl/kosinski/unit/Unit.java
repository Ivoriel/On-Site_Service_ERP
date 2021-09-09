package pl.kosinski.unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.kosinski.client.Client;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String serialNumber;
    @ManyToOne
    private Client client;

    public void setUnitInfo(String serialNumber, Client client) {
        this.serialNumber = serialNumber;
        this.client = client;
    }

}
