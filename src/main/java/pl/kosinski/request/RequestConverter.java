package pl.kosinski.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.kosinski.task.TaskCrudService;
import pl.kosinski.task.TaskInfoDto;

@Component
public class RequestConverter implements Converter<String, RequestInfoDto> {

    @Autowired
    private RequestCrudService requestCrudService;

    public RequestInfoDto convert(String source) {
        return requestCrudService.findRequestbyId(Long.parseLong(source));
    }

}
