package Day_0905.LogBaseSRP;

import java.io.File;

public class LogDirectory {
    private final File logDir;

    public LogDirectory() {
        this.logDir = new File(System.getProperty("user.dir"), "log");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
    }

    public File getLogDir() {
        return logDir;
    }

    public void printPath() {
        System.out.println("로그 폴더 위치: " + logDir.getAbsolutePath());
    }
}