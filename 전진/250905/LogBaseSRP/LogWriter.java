package Day_0905.LogBaseSRP;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");
    private final File logDir;

    public LogWriter(File logDir) {
        this.logDir = logDir;
    }

    public void startRecord(int period) {
        String filenamePrefix = LocalDateTime.now().format(DATE_FORMATTER);
        writeRecord(filenamePrefix, period);
        System.out.println("기록을 종료합니다.");
    }

    private void writeRecord(String filename, int period) {
        File errorFile = new File(logDir, filename + "ErrorLog.txt");
        File accessFile = new File(logDir, filename + "AccessLog.txt");
        File totalFile = new File(logDir, filename + "MergeLog.txt");

        try (PrintWriter errorWriter = new PrintWriter(new FileWriter(errorFile, true));
             PrintWriter accessWriter = new PrintWriter(new FileWriter(accessFile, true));
             PrintWriter totalWriter = new PrintWriter(new FileWriter(totalFile, true))) {

            for (int i = 1; i <= period; i++) {
                try {
                    //논블로킹 방식, 기존 System.in은 블로킹 방식으로 입력이 들어올때까지 무조건 기다리는데,
                    // 논블로킹으로 바꿔줘서 입력을 기다리지 않음.
                    if (System.in.available() > 0) {
                        new java.util.Scanner(System.in).nextLine(); // 입력 소비
                        throw new RuntimeException("예상치 못한 사용자 입력 발생");
                    }

                    System.out.print(i + "...");
                    log(accessWriter, totalWriter, "[ACCESS] " + LocalDateTime.now());
                    Thread.sleep(1000);

                } catch (RuntimeException e) {
                    log(errorWriter, totalWriter, "[ERROR] " + LocalDateTime.now() + " - " + e.getMessage());
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("[ERROR] " + LocalDateTime.now() + " - 로그 작성 오류: " + e.getMessage());
        }
    }

    private void log(PrintWriter writer1, PrintWriter writer2, String message) {
        writer1.println(message);
        writer2.println(message);
        writer1.flush();
        writer2.flush();
    }
}