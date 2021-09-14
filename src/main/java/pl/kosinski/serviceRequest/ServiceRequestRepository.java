package pl.kosinski.serviceRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    @Query(value = "SELECT * FROM service_request s " +
            "JOIN service_requests_units ru ON s.id = ru.service_request_id " +
            "JOIN unit u ON ru.unit_id = u.id" +
            "WHERE u.client_id = :id", nativeQuery = true)
    List<ServiceRequest> getServiceReqByClientId(long id);

    @Query(value = "SELECT * FROM service_request s " +
            "JOIN service_requests_units ru ON s.id = ru.service_request_id " +
            "WHERE ru.unit_id = :id", nativeQuery = true)
    List<ServiceRequest> getServiceReqByUnitId(long id);
}
