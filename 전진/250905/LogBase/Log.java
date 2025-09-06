package Day_0904.LogBase;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Log {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static void startRecord() {
        // log 디렉토리 경로
        File logDir = getLogDirectory();
        Scanner scanner = new Scanner(System.in);

        System.out.print("로그를 몇 초동안 기록할까요? ");
        int period=scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        String filenamePrefix = LocalDateTime.now().format(DATE_FORMATTER);

        WriteRecord(logDir,filenamePrefix,period);

        System.out.println("기록을 종료합니다. ");

    }
    public static void WriteRecord(File logDir, String filename,int period) {

        File ErrorlogFile = new File(logDir, filename+"Errorlog.txt");
        File AccesslogFile = new File(logDir, filename+"AccessLog.txt");
        File TotallogFile = new File(logDir, filename+"MergeLog.txt");

        Scanner scanner = new Scanner(System.in);

        try (PrintWriter Errorwriter = new PrintWriter(new FileWriter(ErrorlogFile, true));
        PrintWriter Accesswriter = new PrintWriter(new FileWriter(AccesslogFile, true));
        PrintWriter Totalwriter = new PrintWriter(new FileWriter(TotallogFile, true))){
            for (int i = 1; i <= period; i++) {
                try {
                    if (System.in.available() > 0) {
                        //논블로킹 방식, 기존 System.in은 블로킹 방식으로 입력이 들어올때까지 무조건 기다리는데,
                        // 논블로킹으로 바꿔줘서 입력을 기다리지 않음.

                        new Scanner(System.in).nextLine();// 입력 소비 (버퍼 비우기)
                        throw new RuntimeException("예상치 못한 사용자 입력 발생");
                    }
                    System.out.print(i + "...");
                    Accesswriter.println("[ACCESS] " + LocalDateTime.now());
                    Totalwriter.println("[ACCESS] " + LocalDateTime.now());
                    Accesswriter.flush();
                    Totalwriter.flush();
                    Thread.sleep(1000);
                } catch (RuntimeException e) {
                    Errorwriter.println("[ERROR] " + LocalDateTime.now() + " - " + e.getMessage());
                    Totalwriter.println("[ERROR] " + LocalDateTime.now() + " - " + e.getMessage());
                    Errorwriter.flush();
                    Totalwriter.flush();
                }
            }
        } catch (IOException e) {
            System.err.println("[ERROR] " + LocalDateTime.now() + " - 파일 생성 중 오류: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("[ERROR] " + LocalDateTime.now() + " - 로그 작성 대기시간 중 오류: " + e.getMessage());
        }
    }

    public static void readRecord() {
        // log 디렉토리 경로
        File logDir = getLogDirectory();
        if (!logDir.exists()) {
            System.out.println("로그가 존재하지 않습니다.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("로그 파일 목록:");
        File[] logList=logDir.listFiles();
        for (File file : logList) {
            System.out.println(file.getName());
        }

        System.out.print("확인할 로그 파일 이름을 정확히 입력하세요 : ");
        String Filename=scanner.nextLine();
        File logFile=new File(logDir,Filename);

        if (!logFile.exists()) {
            System.out.println(Filename+"파일이 존재하지 않습니다. 다시 확인해주세요.");
            return;
        }

        System.out.println("============로그 시작============");
        try(BufferedReader br = new BufferedReader(new FileReader(logFile))){
            String line;
            int lineNumber=1;
            while((line=br.readLine())!=null){
                // 줄 번호 추가하여 쓰기
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        }catch(IOException e){
            System.out.println("파일 읽기 중 IO오류"+e.getMessage());
        }
        System.out.println("============로그 종료============");



    }

    // 로그 폴더 경로 가져오기
    private static File getLogDirectory() {
        File logDir = new File(System.getProperty("user.dir"), "log");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
        System.out.println("로그 폴더 위치: " + logDir.getAbsolutePath());
        return logDir;
    }
}
