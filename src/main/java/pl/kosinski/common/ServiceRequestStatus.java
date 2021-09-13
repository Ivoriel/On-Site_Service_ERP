package pl.kosinski.common;

public enum ServiceRequestStatus {
    OPEN(true),
    CLOSED(false);

    private boolean status;

    ServiceRequestStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
