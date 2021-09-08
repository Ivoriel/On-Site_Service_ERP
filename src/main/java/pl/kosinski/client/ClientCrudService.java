package pl.kosinski.client;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientCrudService {

    public void saveClient(ClientInfoDto clientInfoDto);

    public ClientInfoDto findClientById (long id);

    public void deleteClient(long id);

    public List<ClientInfoDto> findAllClients();

}
