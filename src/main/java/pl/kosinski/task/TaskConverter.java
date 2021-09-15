package pl.kosinski.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements Converter<String, TaskInfoDto> {

    @Autowired
    private TaskCrudService taskCrudService;

    public TaskInfoDto convert(String source) {
        return taskCrudService.findTaskById(Long.parseLong(source));
    }

}
