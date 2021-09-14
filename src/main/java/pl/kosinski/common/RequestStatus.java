package pl.kosinski.common;

public enum RequestStatus {
    OPEN(true),
    CLOSED(false);

    private boolean status;

    RequestStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }
}
