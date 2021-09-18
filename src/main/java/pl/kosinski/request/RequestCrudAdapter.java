package pl.kosinski.request;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kosinski.unit.Unit;
import pl.kosinski.unit.UnitListDto;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RequestCrudAdapter implements RequestCrudService {

    private RequestRepository repository;

    @Override
    public RequestInfoDto saveRequest(RequestInfoDto requestInfoDto) {
        Request request = new Request();
        if (requestInfoDto.getId() != null) {
            request = getById(requestInfoDto.getId());
            request.setRequestInfo(requestInfoDto.getClient(), requestInfoDto.getType(), requestInfoDto.getStatus(), requestInfoDto.getBrief(), requestInfoDto.getDebrief());
            request.updateTasksAndUnits(requestInfoDto.getTasks(), requestInfoDto.getUnits());
            request.updateWorkTime(requestInfoDto.getWorkTime());
            repository.save(request);
        } else {
            request.setRequestInfo(requestInfoDto.getClient(), requestInfoDto.getType(), requestInfoDto.getStatus(), requestInfoDto.getBrief(), requestInfoDto.getDebrief());
            request.updateTasksAndUnits(requestInfoDto.getTasks(), requestInfoDto.getUnits());
            request.updateWorkTime(requestInfoDto.getWorkTime());
            repository.save(request);
        }
        requestInfoDto.setId(request.getId());
        return requestInfoDto;
    }

    private Request getById(long id) {
        return repository.getById(id);
    }

    @Override
    public RequestInfoDto findRequestbyId(long id) {
        return translateToDto(getById(id));
    }

    @Override
    public void deleteRequest(long id) {
        repository.delete(getById(id));
    }

    @Override
    public List<RequestInfoDto> findAllRequests() {
        List<Request> requestList = repository.findAll();
        List<RequestInfoDto> requestInfoDtoList = new ArrayList<>();
        for (Request request : requestList) {
            requestInfoDtoList.add(translateToDto(request));
        }
        return requestInfoDtoList;
    }

    @Override
    public void addUnitsToRequest(long id, UnitListDto unitListDto) {
        RequestInfoDto requestInfoDto = findRequestbyId(id);
        List <Unit> requestunitList = requestInfoDto.getUnits();
        for (Unit unit : unitListDto.getUnits()) {
            if (!requestunitList.contains(unit)) {
                requestunitList.add(unit);
            }
        }
        requestInfoDto.setUnits(requestunitList);
        saveRequest(requestInfoDto);
    }

    @Override
    public void removeUnitsFromRequest(long id, UnitListDto unitListDto) {
        RequestInfoDto requestInfoDto = findRequestbyId(id);
        List <Unit> requestunitList = requestInfoDto.getUnits();
        for (Unit unit : unitListDto.getUnits()) {
            if (requestunitList.contains(unit)) {
                requestunitList.remove(unit);
            }
        }
        requestInfoDto.setUnits(requestunitList);
        saveRequest(requestInfoDto);
    }

    @Override
    public List<RequestInfoDto> getRequestsByClientId(long id) {
        List<Request> requestList = repository.getServiceReqByClientId(id);
        List<RequestInfoDto> requestInfoDtoList = new ArrayList<>();
        for (Request request : requestList) {
            requestInfoDtoList.add(translateToDto(request));
        }
        return requestInfoDtoList;
    }

    @Override
    public List<RequestInfoDto> getRequestsByUnitId(long id) {
        List<Request> requestList = repository.getServiceReqByUnitId(id);
        List<RequestInfoDto> requestInfoDtoList = new ArrayList<>();
        for (Request request : requestList) {
            requestInfoDtoList.add(translateToDto(request));
        }
        return requestInfoDtoList;
    }

    @Override
    public void addToWorkTime(RequestWorkTimeDto requestWorkTimeDto) {
        Request request = getById(requestWorkTimeDto.getRequestId());
        if (request.getWorkTime() == null) {
            request.updateWorkTime(requestWorkTimeDto.getWorkTime());
        } else {
            int requestWorkTime = request.getWorkTime();
            requestWorkTime = requestWorkTime + requestWorkTimeDto.getWorkTime();
            request.updateWorkTime(requestWorkTime);
        }
        repository.save(request);
    }

    @Override
    public void subtractFromWorkTime(RequestWorkTimeDto requestWorkTimeDto) {
        Request request = getById(requestWorkTimeDto.getRequestId());
        int requestWorkTime = request.getWorkTime();
        if (requestWorkTimeDto.getWorkTime() <= requestWorkTime){
            requestWorkTime = requestWorkTime - requestWorkTimeDto.getWorkTime();
            request.updateWorkTime(requestWorkTime);
            repository.save(request);
        }
    }

    private RequestInfoDto translateToDto(Request request) {
        RequestInfoDto requestDto = new RequestInfoDto();
        requestDto.setId(request.getId());
        requestDto.setClient(request.getClient());
        requestDto.setType(request.getType());
        requestDto.setStatus(request.getStatus());
        requestDto.setBrief(request.getBrief());
        requestDto.setDebrief(request.getDebrief());
        requestDto.setUnits(request.getUnits());
        requestDto.setTasks(request.getTasks());
        requestDto.setWorkTime(request.getWorkTime());
        return requestDto;
    }
}
