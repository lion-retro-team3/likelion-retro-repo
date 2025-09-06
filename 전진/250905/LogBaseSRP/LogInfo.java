package Day_0905.LogBaseSRP;

import java.time.LocalDateTime;

public class LogInfo {
    private final LocalDateTime timestamp;
    private final String type;
    private final String message;

    public LogInfo(String type, String message) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.message = message;
    }
    @Override
    public String toString() {
        return "[" + type + "] " + timestamp + " - " + message;
    }
}
