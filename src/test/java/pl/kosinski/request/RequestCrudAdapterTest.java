package pl.kosinski.request;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
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

import static org.junit.Assert.assertEquals;

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
        RequestCrudAdapter requestCrudAdapter = new RequestCrudAdapter(requestRepository);
        RequestInfoDto request = generateRequestWithoutTasksAndWorkTime();
        requestCrudAdapter.saveRequest(request);
        request.setId(1L);
        assertEquals(request, requestCrudAdapter.findRequestbyId(1));
    }

    @Test
    void findRequestbyId() {
    }

    @Test
    void deleteRequest() {
    }

    @Test
    void findAllRequests() {
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