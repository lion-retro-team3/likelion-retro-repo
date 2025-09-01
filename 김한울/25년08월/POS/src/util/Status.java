package util;

public enum Status {
    WAIT("대기"),
    SUCCESS("성공"),
    FAIL("실패"),
    CANCEL("취소");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
