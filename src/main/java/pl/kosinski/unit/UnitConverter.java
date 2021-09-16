package pl.kosinski.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.kosinski.task.TaskCrudService;
import pl.kosinski.task.TaskInfoDto;

@Component
public class UnitConverter implements Converter<String, UnitInfoDto> {

    @Autowired
    private UnitCrudService unitCrudService;

    public UnitInfoDto convert(String source) {
        return unitCrudService.findUnitbyId(Long.parseLong(source));
    }

}
