package pl.kosinski.client;

import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitCrudAdapterTest {

    @BeforeEach
    public void init(){
        Map<Long, Unit> repository = new HashMap<>();
    }

//    @Test
//    void saveClient() {
////        ClientCrudAdapter clientCrudAdapter = new ClientCrudAdapter(repository);
//        ClientInfoDto clientInfoDto1 = new ClientInfoDto();
//        clientInfoDto1.setId(1L);
//        clientInfoDto1.setName("testName1");
//        ClientInfoDto clientInfoDto2 = new ClientInfoDto();
//        clientInfoDto2.setName("testName1");
//        clientCrudAdapter.saveClient(clientInfoDto2);
//        assertEquals(clientInfoDto1, clientCrudAdapter.findClientById(1));
//    }

//    @Test
//    void findClientById() {
//    }
//
//    @Test
//    void deleteClient() {
//    }
//
//    @Test
//    void findAllClients() {
//    }
}