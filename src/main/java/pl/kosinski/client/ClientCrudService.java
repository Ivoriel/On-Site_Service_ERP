package pl.kosinski.client;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientCrudService {

    ClientInfoDto saveClient(ClientInfoDto clientInfoDto);

    ClientInfoDto findClientById (long id);

    void deleteClient(long id);

    List<ClientInfoDto> findAllClients();

}
