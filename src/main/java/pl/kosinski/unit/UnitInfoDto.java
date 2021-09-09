package pl.kosinski.unit;

import lombok.Data;
import pl.kosinski.client.Client;

@Data
public class UnitInfoDto {

    private Long id;
    private String serialNumber;
    private Client client;
}
