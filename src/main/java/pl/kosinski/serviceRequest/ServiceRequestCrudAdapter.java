package pl.kosinski.serviceRequest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return translateToDto(getById(id));
    }

    @Override
    public void deleteServiceRequest(long id) {
        repository.delete(getById(id));
    }

    @Override
    public List<ServiceRequestInfoDto> findAllServiceRequests() {
        List<ServiceRequest> requestList = repository.findAll();
        List<ServiceRequestInfoDto> requestInfoDtoList = new ArrayList<>();
        for (ServiceRequest request : requestList) {
            requestInfoDtoList.add(translateToDto(request));
        }
        return requestInfoDtoList;
    }

    @Override
    public List<ServiceRequestInfoDto> getServiceReqByClientId(long id) {
        List<ServiceRequest> requestList = repository.getServiceReqByClientId(id);
        List<ServiceRequestInfoDto> requestInfoDtoList = new ArrayList<>();
        for (ServiceRequest request : requestList) {
            requestInfoDtoList.add(translateToDto(request));
        }
        return requestInfoDtoList;
    }

    @Override
    public List<ServiceRequestInfoDto> getServiceReqByUnitId(long id) {
        List<ServiceRequest> requestList = repository.getServiceReqByUnitId(id);
        List<ServiceRequestInfoDto> requestInfoDtoList = new ArrayList<>();
        for (ServiceRequest request : requestList) {
            requestInfoDtoList.add(translateToDto(request));
        }
        return requestInfoDtoList;
    }

    private ServiceRequestInfoDto translateToDto(ServiceRequest request) {
        ServiceRequestInfoDto requestDto = new ServiceRequestInfoDto();
        requestDto.setId(request.getId());
        requestDto.setType(request.getType());
        requestDto.setStatus(request.getStatus());
        requestDto.setBrief(request.getBrief());
        requestDto.setDebrief(request.getDebrief());
        requestDto.setUnits(request.getUnits());
        requestDto.setTasks(request.getServiceTasks());
        return requestDto;
    }
}
