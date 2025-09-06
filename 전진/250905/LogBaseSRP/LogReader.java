package Day_0905.LogBaseSRP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
    private final File logDir;

    public LogReader(File logDir) {
        this.logDir = logDir;
    }

    public void showLogList() {
        File[] logFiles = logDir.listFiles();
        if (logFiles == null || logFiles.length == 0) {
            System.out.println("로그가 존재하지 않습니다.");
            return;
        }
        System.out.println("로그 파일 목록:");
        for (File file : logFiles) {
            System.out.println(file.getName());
        }
    }

    public void readLog(String filename) {
        File logFile = new File(logDir, filename);

        if (!logFile.exists()) {
            System.out.println(filename + " 파일이 존재하지 않습니다. 다시 확인해주세요.");
            return;
        }

        System.out.println("============로그 시작============");
        try (BufferedReader br = new BufferedReader(new FileReader(logFile))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 중 IO 오류: " + e.getMessage());
        }
        System.out.println("============로그 종료============");
    }
}