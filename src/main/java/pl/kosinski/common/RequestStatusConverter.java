package pl.kosinski.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestStatusConverter implements Converter<String, RequestStatus> {

    public RequestStatus convert(String source) {
        for (RequestStatus rs : RequestStatus.values()) {
            if(rs.getLabel().equalsIgnoreCase(source)) {
                return rs;
            }
        }
        return null;
    }

}
