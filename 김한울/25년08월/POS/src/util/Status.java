package util;

//어떤 상태값
public enum Status {
    KEEP("유지"),
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
