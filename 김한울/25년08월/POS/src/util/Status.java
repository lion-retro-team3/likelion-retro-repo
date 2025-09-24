package util;

public enum Status {
    WAIT("대기"),
    SUCCESS("성공"),
    FAIL("실패"),
    IN_PROGRESS("진행 중"),
    CANCEL("취소");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Status fromString(String value) {
        switch (value) {
            case "WAIT":
                return WAIT;
            case "SUCCESS":
                return SUCCESS;
            case "FAIL":
                return FAIL;
            case "IN_PROGRESS":
                return IN_PROGRESS;
            case "CANCEL":
                return CANCEL;
            default:
                return null;
        }
    }

}
