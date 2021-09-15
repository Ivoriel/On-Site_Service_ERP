package pl.kosinski.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestType {
    START_UP ("Start-up"),
    SHUT_DOWN ("Shut-down"),
    MAINTENANCE ("Maintenance"),
    REPAIR ("Repair"),
    UPGRADE ("Upgrade"),
    CONFIGURATION ("Configuration"),
    TRAINING ("Training");

    private String label;

    public static RequestType fromLabel(String label) {
        for (RequestType rt : RequestType.values()) {
            if(rt.label.equalsIgnoreCase(label)) {
                return rt;
            }
        }
        return null;
    }
}
