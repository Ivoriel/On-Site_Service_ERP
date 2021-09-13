package pl.kosinski.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientCrudAdapter implements ClientCrudService{

    private ClientRepository repository;

    @Override
    public ClientInfoDto saveClient(ClientInfoDto clientInfoDto) {
        Client client = new Client();
        if (clientInfoDto.getId() != null) {
            client = getClientbyId(clientInfoDto.getId());
            client.setName(clientInfoDto.getName());
            client = repository.save(client);
        } else {
            client.setName(clientInfoDto.getName());
            client = repository.save(client);
        }
        clientInfoDto.setId(client.getId());
        return clientInfoDto;
    }

    private Client getClientbyId(long id) {
        return repository.findById(id).get();
    }

    @Override
    public ClientInfoDto findClientById(long id) {
        Client client = getClientbyId(id);
        ClientInfoDto clientInfoDto = new ClientInfoDto();
        clientInfoDto.setId(client.getId());
        clientInfoDto.setName(client.getName());
        return clientInfoDto;
    }

    @Override
    public void deleteClient(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ClientInfoDto> findAllClients() {
        List<ClientInfoDto> clientList = new ArrayList<>();
        for (Client c : repository.findAll()) {
            ClientInfoDto clientInfoDto = new ClientInfoDto();
            clientInfoDto.setId(c.getId());
            clientInfoDto.setName(c.getName());
            clientList.add(clientInfoDto);
        }
        return clientList;
    }
}
