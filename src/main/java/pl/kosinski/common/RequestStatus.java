package pl.kosinski.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestStatus {
    OPEN(true, "Open"),
    CLOSED(false, "Closed");

    private boolean status;
    private String label;

    public static RequestStatus fromLabel(String label) {
        for (RequestStatus rs : RequestStatus.values()) {
            if(rs.label.equalsIgnoreCase(label)) {
                return rs;
            }
        }
        return null;
    }

}
