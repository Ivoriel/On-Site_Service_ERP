package pl.kosinski.client;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ClientCrudAdapterTest {

    @Autowired
    ClientRepository repository;

    @Test
    void givenClientNotInDb_whenClientAddedToDb_thenClientShouldBeRetrievable() {
        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(repository);
        ClientInfoDto clientInfoDto1 = new ClientInfoDto();
        clientInfoDto1.setId(1L);
        clientInfoDto1.setName("testName1");
        ClientInfoDto clientInfoDto2 = new ClientInfoDto();
        clientInfoDto2.setName("testName1");
        clientCrudAdapter.saveClient(clientInfoDto2);
        assertEquals(clientInfoDto1, clientCrudAdapter.findClientById(1));
    }

    @Test
    void givenClientPresentInDb_whenClientRemovedFromDb_thenClientShouldNotBeRetrievable() {
        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(repository);
        ClientInfoDto clientInfoDto1 = new ClientInfoDto();
        clientInfoDto1.setId(1L);
        clientInfoDto1.setName("testName1");
        ClientInfoDto clientInfoDto2 = new ClientInfoDto();
        clientInfoDto2.setName("testName1");
        clientCrudAdapter.saveClient(clientInfoDto2);
        assertEquals(clientInfoDto1, clientCrudAdapter.findClientById(1));
        clientCrudAdapter.deleteClient(1);
        assertThrows(NoSuchElementException.class, () -> clientCrudAdapter.findClientById(2));
    }

    @Test
    void givenClientsArePresentInDb_whenClientListIsCalled_thenClientListShouldBeRetrievable() {
        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(repository);
        ClientInfoDto clientInfoDto1 = new ClientInfoDto();
        clientInfoDto1.setName("testName1");
        clientCrudAdapter.saveClient(clientInfoDto1);
        clientInfoDto1.setId(1L);
        ClientInfoDto clientInfoDto2 = new ClientInfoDto();
        clientInfoDto2.setName("testName1");
        clientCrudAdapter.saveClient(clientInfoDto2);
        clientInfoDto2.setId(2L);
        List<ClientInfoDto> clientList = List.of(clientInfoDto1, clientInfoDto2);
        assertEquals(clientList, clientCrudAdapter.findAllClients());
    }
}