package pl.kosinski.client;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clients/rest")
@AllArgsConstructor
public class ClientRestController {

    private ClientCrudService clientCrudService;

    @GetMapping("")
    public List<ClientInfoDto> allClients() {
        return clientCrudService.findAllClients();
    }

}
