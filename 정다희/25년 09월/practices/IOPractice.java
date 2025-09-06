package day12.logDir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IOPractice {

    public static final String FILE_PATH = "src/day12/logDir/";
    public static final String FILE_EXTENSION = ".txt";

    private static final BufferedReader INPUT = new BufferedReader(new InputStreamReader(System.in));
    private static final DateTimeFormatter TS_FMT = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH:mm:ss");

    // accessLog 파일 만드는 메서드
    public static void saveAccessLog(String fileNm) {
        try (
               PrintWriter wr = new PrintWriter(new FileWriter(FILE_PATH + fileNm + FILE_EXTENSION))
        ) {
            System.out.print("남길 로그의 갯수 입력: ");
            int logCnt = Integer.parseInt(INPUT.readLine());

            System.out.println("로그 생성 중..");

            try {
                for (int i = 0; i < logCnt; i++) {
                    String time = LocalDateTime.now().format(TS_FMT);
                    wr.println("[ACCESS] " + time);

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e1) {
                throw new RuntimeException(e1);
            }

            System.out.println("로그 생성 완료");

        } catch (NumberFormatException e2) {
            System.err.println("숫자 형식 오류: " + e2.getMessage());
        } catch (IOException e3) {
            System.err.println("입력 오류: " + e3.getMessage());
        }
    }

    // errorLog 파일 만드는 메서드
    public static void saveErrorLog(String fileNm) {
        try (
                PrintWriter wr = new PrintWriter(new FileWriter(FILE_PATH + fileNm + FILE_EXTENSION))
        ) {
            System.out.print("남길 에러 로그의 갯수 입력: ");
            int logCnt = Integer.parseInt(INPUT.readLine());

            System.out.println("에러 로그 생성중...");

            try {
                for (int i = 0; i < logCnt; i++) {
                    String time = LocalDateTime.now().format(TS_FMT);
                    wr.println("[ERROR] " + time);

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e1) {
                throw new RuntimeException(e1);
            }

            System.out.println("에러 로그 생성 완료");

        } catch (NumberFormatException e2) {
            System.err.println("숫자 형식 오류: " + e2.getMessage());
        } catch (IOException e3) {
            System.err.println("입력 오류: " + e3.getMessage());
        }
    }

    // 두개의 파일 merge 하는 메서드
    public static void mergeLog(String accessFileNm, String ErrorFileNm, String mergeFileNm) {
        try (
                BufferedReader aLogBr = new BufferedReader(new FileReader(FILE_PATH + accessFileNm + FILE_EXTENSION));
                BufferedReader eLogBr = new BufferedReader(new FileReader(FILE_PATH + ErrorFileNm + FILE_EXTENSION));
                PrintWriter wr = new PrintWriter(new FileWriter(FILE_PATH + mergeFileNm + FILE_EXTENSION));
        ) {
            System.out.println("로그 파일 병합 시작");

            String line;

            while((line = aLogBr.readLine()) != null) {
                wr.println(line);
            }

            while((line = eLogBr.readLine()) != null) {
                wr.println(line);
            }

            System.out.println("로그 파일 병합 완료");

        } catch (IOException e) {
            System.err.println("파일 오류:  " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        String formatted = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));

        String accessFileNm = "accessLog_" + formatted;
        String errorFileNm = "errorLog_" + formatted;
        String mergeFileNm = "mergeLog_" + formatted;

        saveAccessLog(accessFileNm);
        saveErrorLog(errorFileNm);
        mergeLog(accessFileNm, errorFileNm, mergeFileNm);
    }
}
