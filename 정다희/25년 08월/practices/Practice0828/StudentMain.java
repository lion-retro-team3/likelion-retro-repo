package day09.Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student("001", "kim", 3, "컴퓨터공학과");
        Student s2 = new Student("002", "lee", 2, "경영학과");
        Student s3 = new Student("003", "park", 1, "컴퓨터공학과");
        Student s4 = new Student("004", "jeong", 2, "영어영문학과");
        Student s5 = new Student("005", "choi", 1, "철학과");
        // List
        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        while(true) {
            System.out.print("출력할 학생의 학년을 입력 해 주세요(1~3): ");
            String grade = sc.nextLine();
            int intGrade = Integer.parseInt(grade);
            if(intGrade < 0 || intGrade > 3) {
                System.out.println("1부터 3사이의 숫자를 입력 해 주세요.");
            } else {
                System.out.println("=== " + intGrade + "학년의 정보 입니다. ===");
                for (Student s : studentList) {
                    if(s.getGrade() == intGrade) {
                        System.out.println("이름: " + s.getName() + ", 전공: " + s.getMajor());
                    }
                }
                break;
            }
        }

        System.out.println("==========================");

        // Set
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(s1);
        studentSet.add(s2);
        studentSet.add(s3);
        studentSet.add(s4);
        studentSet.add(s5);

        // 5번의 학생과 동일한 학번인 6번 학생
        Student s6 = new Student("005", "kang", 3, "사회체육과");
        studentSet.add(s6);
        // s6은 같은 학번이 들어갔기 때문에 무시가 됨.
        System.out.println(studentSet);

        // Map
        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put(s1.getStudentId(), s1);
        studentMap.put(s2.getStudentId(), s2);
        studentMap.put(s3.getStudentId(), s3);
        studentMap.put(s4.getStudentId(), s4);
        studentMap.put(s5.getStudentId(), s5);

        System.out.print("조회 할 학생의 학번을 입력하세요: ");
        String inputId = sc.nextLine();
        System.out.println(studentMap.get(inputId));

        // 응용
        Map<String, List<Student>> majorMap = new HashMap<>();
        for (Student s : studentList) {
            String major = s.getMajor();

            if(!majorMap.containsKey(major)) {
                majorMap.put(major, new ArrayList<>());
            }
            majorMap.get(major).add(s);
        }

        for (String m : majorMap.keySet()) {
            System.out.print(m + ": ");
            for(Student s : majorMap.get(m)) {
                System.out.print(s.getName() + " ");
            }
            System.out.println();
        }
    }
}
