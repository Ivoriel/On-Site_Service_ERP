package pl.kosinski.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> getServiceReqByClientId(long id);

    @Query(value = "SELECT * FROM service_request s " +
            "JOIN service_requests_units ru ON s.id = ru.service_request_id " +
            "WHERE ru.unit_id = :id", nativeQuery = true)
    List<Request> getServiceReqByUnitId(long id);
}
