package pl.kosinski.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskStatusConverter implements Converter<String, TaskStatus> {

    @Override
    public TaskStatus convert(String source) {
        for (TaskStatus ts : TaskStatus.values()) {
            if(ts.getLabel().equalsIgnoreCase(source)) {
                return ts;
            }
        }
        return null;
    }
}
