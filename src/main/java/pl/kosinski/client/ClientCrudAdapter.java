package pl.kosinski.client;

import java.util.ArrayList;
import java.util.List;

public class ClientCrudAdapter implements ClientCrudService{

    private ClientRepository clientRepository;

    @Override
    public void saveClient(ClientInfoDto clientInfoDto) {
//        if (clientInfoDto.getId() != null) {
//            Client client = getClientbyId(clientInfoDto.getId());
//            client.setName(clientInfoDto.getName());
//            clientRepository.save(client);
//        } else {
//
//        }
        Client client = getClientbyId(clientInfoDto.getId());
        client.setName(clientInfoDto.getName());
        clientRepository.save(client);
    }

    private Client getClientbyId(long id) {
        return clientRepository.findById(id).get();
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
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientInfoDto> findAllClients() {
        List<ClientInfoDto> clientList = new ArrayList<>();
        for (Client c : clientRepository.findAll()) {
            ClientInfoDto clientInfoDto = new ClientInfoDto();
            clientInfoDto.setId(c.getId());
            clientInfoDto.setName(c.getName());
            clientList.add(clientInfoDto);
        }
        return clientList;
    }
}
