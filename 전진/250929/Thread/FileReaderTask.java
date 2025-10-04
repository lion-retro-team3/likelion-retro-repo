package Practice.Thread;
import java.awt.*;
import java.io.*;

public class FileReaderTask implements Runnable {
    private final String filePath;

    public FileReaderTask(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " - 파일 읽기 시작: " + filePath);
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(Thread.currentThread().getName() + " - " + lineNumber++ + "행 : " + line);
                Thread.sleep(50);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
        }
        System.out.println(Thread.currentThread().getName() + " - 파일 읽기 완료");
    }

    // 👉 OS 네이티브 탐색기 다이얼로그
    public static String chooseFilePath() {
        FileDialog dialog = new FileDialog((Frame) null, "읽을 파일 선택", FileDialog.LOAD);
        dialog.setDirectory("C:\\Users\\yusen\\IdeaProjects\\likelion"); // 기본 경로 지정
        dialog.setVisible(true); // 윈도우 탐색기 창 열기

        if (dialog.getFile() != null) {
            return dialog.getDirectory() + dialog.getFile(); // 선택한 파일 경로 반환
        }
        return null;
    }

    public static void main(String[] args) {
        String path = chooseFilePath();
        if (path != null) {
            Thread t = new Thread(new FileReaderTask(path), "FileReaderThread");
            t.start();
        } else {
            System.out.println("파일을 선택하지 않았습니다.");
        }
    }
}