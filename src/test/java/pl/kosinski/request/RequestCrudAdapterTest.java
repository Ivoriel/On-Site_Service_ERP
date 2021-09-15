package pl.kosinski.request;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class RequestCrudAdapterTest {

    @Autowired
    RequestRepository repository;

    @Test
    void givenRequestNotPresentInDb_whenRequestAddedtoDB_thenRequestShouldBeRetrievable() {
        RequestCrudAdapter requestCrudAdapter = new RequestCrudAdapter(repository);
        Request request = new Request();
//        request.setRequestInfo(ServiceRequestType.MAINTENANCE, ServiceRequestStatus.OPEN, "Test brief1");

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
}