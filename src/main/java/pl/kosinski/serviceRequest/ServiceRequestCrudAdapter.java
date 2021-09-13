package pl.kosinski.serviceRequest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceRequestCrudAdapter implements ServiceRequestCrudService {

    private ServiceRequestRepository repository;

    @Override
    public void saveServiceRequest(ServiceRequestInfoDto requestInfoDto) {
        ServiceRequest request = new ServiceRequest();
        if (requestInfoDto.getId() != null) {
            request = getById(requestInfoDto.getId());
            request.setRequestInfo(requestInfoDto.getType(), requestInfoDto.getStatus(), requestInfoDto.getBrief());
            repository.save(request);
        } else {
            request.setRequestInfo(requestInfoDto.getType(), requestInfoDto.getStatus(), requestInfoDto.getBrief());
            repository.save(request);
        }
    }

    private ServiceRequest getById(long id) {
        return repository.getById(id);
    }

    @Override
    public ServiceRequestInfoDto findServiceRequestbyId(long id) {
        return null;
    }

    @Override
    public void deleteServiceRequest(long id) {

    }

    @Override
    public List<ServiceRequestInfoDto> findAllServiceRequests() {
        return null;
    }

    @Override
    public List<ServiceRequestInfoDto> getServiceReqByClientId(long id) {
        return null;
    }

    @Override
    public List<ServiceRequestInfoDto> getServiceReqByUnitId(long id) {
        return null;
    }
}
