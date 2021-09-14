package pl.kosinski.request;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RequestCrudService {

    public RequestInfoDto saveRequest(RequestInfoDto requestInfoDto);

    public RequestInfoDto findRequestbyId(long id);

    public void deleteRequest(long id);

    public List<RequestInfoDto> findAllRequests();

    public List<RequestInfoDto> getRequestsByClientId(long id);

    public List<RequestInfoDto> getRequestsByUnitId(long id);

}
