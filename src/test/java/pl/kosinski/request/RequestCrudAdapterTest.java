package pl.kosinski.request;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kosinski.client.Client;
import pl.kosinski.client.ClientRepository;
import pl.kosinski.common.RequestStatus;
import pl.kosinski.common.RequestType;
import pl.kosinski.unit.Unit;
import pl.kosinski.unit.UnitRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RequestCrudAdapterTest {

    @Autowired
    RequestRepository requestRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    UnitRepository unitRepository;

    @Test
    void givenRequestNotPresentInDb_whenRequestAddedToDB_thenRequestShouldBeRetrievable() {
        var requestCrudAdapter = new RequestCrudAdapter(requestRepository);
        var client = generateUniqueClient();
        var request = generateRequestWithoutTasksAndWorkTime(client, generateUniqueUnit(client));
        requestCrudAdapter.saveRequest(request);
        request.setId(1L);
        assertEquals(request, requestCrudAdapter.findRequestbyId(1));
    }

    @Test
    void givenRequestPresentInDb_whenRequestDeletedFromDb_thenRequestShouldNotBeRetrievable() {
        var requestCrudAdapter = new RequestCrudAdapter(requestRepository);
        var client = generateUniqueClient();
        var request = generateRequestWithoutTasksAndWorkTime(client, generateUniqueUnit(client));
        requestCrudAdapter.saveRequest(request);
        request.setId(1L);
        assertEquals(request, requestCrudAdapter.findRequestbyId(1));
        requestCrudAdapter.deleteRequest(1);
        assertThrows(JpaObjectRetrievalFailureException.class, () -> requestCrudAdapter.findRequestbyId(1));
    }

    @Test
    void givenRequestsPresentInDb_whenFinDAllRequestsMethodCalled_thenAllRequestsShouldBeRetrievable() {
        var requestCrudAdapter = new RequestCrudAdapter(requestRepository);
        List<RequestInfoDto> requestList = new ArrayList<>();
        var client1 = generateUniqueClient();
        var request1 = generateRequestWithoutTasksAndWorkTime(client1, generateUniqueUnit(client1));
        requestCrudAdapter.saveRequest(request1);
        request1.setId(1L);
        requestList.add(request1);
        var client2 = generateUniqueClient();
        var request2 = generateRequestWithoutTasksAndWorkTime(client2, generateUniqueUnit(client2));
        requestCrudAdapter.saveRequest(request2);
        request2.setId(2L);
        requestList.add(request2);
        assertEquals(requestList, requestCrudAdapter.findAllRequests());
    }

    @Test
    void givenRequestsPresentInDb_whenRequestsCalled_thenRequestsShouldBeRetrievableByClientId() {
        var requestCrudAdapter = new RequestCrudAdapter(requestRepository);
        List<RequestInfoDto> requestList = new ArrayList<>();
        var client1 = generateUniqueClient();
        var request1 = generateRequestWithoutTasksAndWorkTime(client1, generateUniqueUnit(client1));
        requestCrudAdapter.saveRequest(request1);
        request1.setId(1L);
        requestList.add(request1);
        var request2 = generateRequestWithoutTasksAndWorkTime(client1, generateUniqueUnit(client1));
        requestCrudAdapter.saveRequest(request2);
        request2.setId(2L);
        requestList.add(request2);
        var client2 = generateUniqueClient();
        var request3 = generateRequestWithoutTasksAndWorkTime(client2, generateUniqueUnit(client2));
        requestCrudAdapter.saveRequest(request3);
        request3.setId(3L);
        assertEquals(requestList, requestCrudAdapter.getRequestsByClientId(client1.getId()));
    }

    @Test
    void givenRequestsPresentInDb_whenRequestsCalled_thenRequestsShouldBeRetrievableByUnitId() {
        var requestCrudAdapter = new RequestCrudAdapter(requestRepository);
        List<RequestInfoDto> requestList = new ArrayList<>();
        var client = generateUniqueClient();
        var unit1 = generateUniqueUnit(client);
        var request1 = generateRequestWithoutTasksAndWorkTime(client, unit1);
        requestCrudAdapter.saveRequest(request1);
        request1.setId(1L);
        requestList.add(request1);
        var request2 = generateRequestWithoutTasksAndWorkTime(client, unit1);
        requestCrudAdapter.saveRequest(request2);
        request2.setId(2L);
        requestList.add(request2);
        var unit2 = generateUniqueUnit(client);
        var request3 = generateRequestWithoutTasksAndWorkTime(client, unit2);
        requestCrudAdapter.saveRequest(request3);
        assertEquals(requestList, requestCrudAdapter.getRequestsByUnitId(unit1.getId()));
    }

    private RequestInfoDto generateRequestWithoutTasksAndWorkTime(Client client, Unit unit) {
        var request = new RequestInfoDto();
        List<Unit> units = new ArrayList<>();
        units.add(unit);
        request.setClient(client);
        request.setType(RequestType.MAINTENANCE);
        request.setStatus(RequestStatus.OPEN);
        request.setBrief("testBrief");
        request.setDebrief("testDebrief");
        request.setUnits(units);
        return request;
    }

    private Client generateUniqueClient() {
        var client = new Client();
        client.setName("clientName");
        clientRepository.save(client);
        return client;
    }

    private Unit generateUniqueUnit(Client client) {
        var unit = new Unit();
        unit.setUnitInfo("12345", client);
        unitRepository.save(unit);
        return unit;
    }

}