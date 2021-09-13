package pl.kosinski.serviceRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceRequestCrudService {

    public void saveServiceRequest(ServiceRequestInfoDto requestInfoDto);

    public ServiceRequestInfoDto findServiceRequestbyId(long id);

    public void deleteServiceRequest(long id);

    public List<ServiceRequestInfoDto> findAllServiceRequests();

    public List<ServiceRequestInfoDto> getServiceReqByClientId(long id);

    public List<ServiceRequestInfoDto> getServiceReqByUnitId(long id);

}
