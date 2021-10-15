package pl.kosinski.request;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kosinski.client.Client;
import pl.kosinski.client.ClientCrudAdapter;
import pl.kosinski.client.ClientInfoDto;
import pl.kosinski.client.ClientRepository;
import pl.kosinski.common.RequestStatus;
import pl.kosinski.common.RequestType;
import pl.kosinski.unit.Unit;
import pl.kosinski.unit.UnitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
        var request = generateRequestWithoutTasksAndWorkTime();
        requestCrudAdapter.saveRequest(request);
        request.setId(1L);
        assertEquals(request, requestCrudAdapter.findRequestbyId(1));
    }

    @Test
    void givenRequestPresentInDb_whenRequestDeletedFromDb_thenRequestShouldNotBeRetrievable() {
        var requestCrudAdapter = new RequestCrudAdapter(requestRepository);
        var request = generateRequestWithoutTasksAndWorkTime();
        requestCrudAdapter.saveRequest(request);
        request.setId(1L);
        assertEquals(request, requestCrudAdapter.findRequestbyId(1));
        requestCrudAdapter.deleteRequest(1);
        assertThrows(JpaObjectRetrievalFailureException.class, () -> requestCrudAdapter.findRequestbyId(1));
    }

    @Test
    void findAllRequests() {
        var requestCrudAdapter = new RequestCrudAdapter(requestRepository);
    }

    @Test
    void getRequestsByClientId() {
    }

    @Test
    void getRequestsByUnitId() {
    }

    private RequestInfoDto generateRequestWithoutTasksAndWorkTime() {
        var request = new RequestInfoDto();
        var client = new Client();
        client.setName("clientName");
        clientRepository.save(client);
        var unit1 = new Unit();
        unit1.setUnitInfo("12345", client);
        unitRepository.save(unit1);
        List<Unit> units = new ArrayList<>();
        units.add(unit1);
        request.setClient(client);
        request.setType(RequestType.MAINTENANCE);
        request.setStatus(RequestStatus.OPEN);
        request.setBrief("testBrief");
        request.setDebrief("testDebrief");
        request.setUnits(units);
        return request;
    }

}