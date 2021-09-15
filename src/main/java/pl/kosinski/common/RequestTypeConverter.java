package pl.kosinski.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RequestTypeConverter implements Converter<String, RequestType> {

    public RequestType convert(String source) {
        for (RequestType rt : RequestType.values()) {
            if (rt.getLabel().equalsIgnoreCase(source)) {
                return rt;
            }
        }
        return null;
    }

}
