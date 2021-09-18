package pl.kosinski.request;

import org.springframework.stereotype.Service;
import pl.kosinski.unit.UnitListDto;

import java.util.List;

@Service
public interface RequestCrudService {

    RequestInfoDto saveRequest(RequestInfoDto requestInfoDto);

    RequestInfoDto findRequestbyId(long id);

    void deleteRequest(long id);

    List<RequestInfoDto> findAllRequests();

    void addUnitsToRequest(long id, UnitListDto unitListDto);

    void removeUnitsFromRequest(long id, UnitListDto unitListDto);

    List<RequestInfoDto> getRequestsByClientId(long id);

    List<RequestInfoDto> getRequestsByUnitId(long id);

    void addToWorkTime(RequestWorkTimeDto requestWorkTimeDto);

    void subtractFromWorkTime(RequestWorkTimeDto requestWorkTimeDto);

}
