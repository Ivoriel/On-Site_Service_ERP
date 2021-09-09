package pl.kosinski.unit;

import org.springframework.stereotype.Service;
import pl.kosinski.unit.UnitInfoDto;

import java.util.List;

@Service
public interface UnitCrudService {

    public void saveUnit(UnitInfoDto unitInfoDto);

    public UnitInfoDto findUnitbyId(long id);

    public void deleteUnit(long id);

    public List<UnitInfoDto> findAllUnits();

    public List<UnitInfoDto> getUnitsByClientId(long id);

}
