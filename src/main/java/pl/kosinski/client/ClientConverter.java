package pl.kosinski.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.kosinski.task.TaskCrudService;
import pl.kosinski.task.TaskInfoDto;

@Component
public class ClientConverter implements Converter<String, ClientInfoDto> {

    @Autowired
    private ClientCrudService clientCrudService;

    public ClientInfoDto convert(String source) {
        return clientCrudService.findClientById(Long.parseLong(source));
    }

}
