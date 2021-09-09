package pl.kosinski.unit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UnitCrudAdapter implements UnitCrudService {

    private UnitRepository repository;

    @Override
    public void saveUnit(UnitInfoDto unitInfoDto) {
        Unit unit = new Unit();
        if (unitInfoDto.getId() != null) {
            unit = getUnitbyId(unitInfoDto.getId());
            unit.setUnitInfo(unit.getSerialNumber(), unit.getClient());
            repository.save(unit);
        } else {
            unit.setUnitInfo(unitInfoDto.getSerialNumber(), unitInfoDto.getClient());
            repository.save(unit);
        }
    }

    private Unit getUnitbyId(long id) {
        return repository.findById(id).get();
    }

    @Override
    public UnitInfoDto findUnitbyId(long id) {
        Unit unit = getUnitbyId(id);
        UnitInfoDto unitInfoDto = new UnitInfoDto();
        unitInfoDto.setId(unit.getId());
        unitInfoDto.setSerialNumber(unit.getSerialNumber());
        unitInfoDto.setClient(unit.getClient());
        return unitInfoDto;
    }

    @Override
    public void deleteUnit(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UnitInfoDto> findAllUnits() {
        List<UnitInfoDto> UnitList = new ArrayList<>();
        for (Unit u : repository.findAll()) {
            UnitInfoDto unitInfoDto = new UnitInfoDto();
            unitInfoDto.setId(u.getId());
            unitInfoDto.setSerialNumber(u.getSerialNumber());
            unitInfoDto.setClient(u.getClient());
            UnitList.add(unitInfoDto);
        }
        return UnitList;
    }

    public List<UnitInfoDto> getUnitsByClientId(long id) {
        List<Unit> unitList = repository.getUnitsByClientId(id);
        List<UnitInfoDto> unitInfoDtoList= new ArrayList<>();
        for (Unit unit : unitList) {
            UnitInfoDto unitInfoDto = new UnitInfoDto();
            unitInfoDto.setId(unit.getId());
            unitInfoDto.setSerialNumber(unit.getSerialNumber());
            unitInfoDto.setClient(unit.getClient());
            unitInfoDtoList.add(unitInfoDto);
        }
        return unitInfoDtoList;
    }
}
