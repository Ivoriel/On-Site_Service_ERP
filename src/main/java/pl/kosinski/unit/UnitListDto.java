package pl.kosinski.unit;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UnitListDto {

    private List<Unit> units = new ArrayList<>();

}
