package pl.kosinski.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskStatus {

    IN_PLANNING(true, "In planning"),
    ASSIGNED(true, "Assigned"),
    IN_PROGRESS(true, "In progress"),
    COMPLETED(false, "Completed"),
    REJECTED(false, "Rejected");

    Boolean status;
    String label;

    public static TaskStatus fromLabel(String label) {
        for (TaskStatus ts : TaskStatus.values()) {
            if(ts.label.equalsIgnoreCase(label)) {
                return ts;
            }
        }
        return null;
    }
}
