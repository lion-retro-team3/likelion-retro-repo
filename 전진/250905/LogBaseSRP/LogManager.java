package Day_0905.LogBaseSRP;
import java.io.File;

import java.util.Scanner;

public class LogManager {
    private final LogDirectory logDirectory;
    private final LogWriter logWriter;
    private final LogReader logReader;
    private final Scanner scanner;

    public LogManager() {
        this.logDirectory = new LogDirectory();
        this.logWriter = new LogWriter(logDirectory.getLogDir());
        this.logReader = new LogReader(logDirectory.getLogDir());
        this.scanner = new Scanner(System.in);
    }

    public void startRecord() {
        logDirectory.printPath();
        System.out.print("로그를 몇 초동안 기록할까요? ");
        int period = scanner.nextInt();
        scanner.nextLine();
        logWriter.startRecord(period);
    }

    public void readRecord() {
        logReader.showLogList();
        System.out.print("확인할 로그 파일 이름을 정확히 입력하세요: ");
        String filename = scanner.nextLine();
        logReader.readLog(filename);
    }
}