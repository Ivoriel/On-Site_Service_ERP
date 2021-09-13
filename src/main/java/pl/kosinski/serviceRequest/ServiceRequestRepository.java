package pl.kosinski.serviceRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {

    List<ServiceRequest> getServiceReqByClientId(long id);

    List<ServiceRequest> getServiceReqByUnitId(long id);
}
