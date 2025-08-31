package day09.Practice;

import java.util.Objects;

public class Student {
    private String studentId;  // 학번
    private String name;       // 이름
    private int grade;         // 학년
    private String major;      // 전공

    // 모든 필드를 입력받는 생성자 생성
    public Student(String studentId, String name, int grade, String major) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.major = major;
    }

    // getter, setter 생성
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    // toString 생성

    @Override
    public String toString() {
        return "Student { " +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                " }";
    }

    // equals, hashCode 생성
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId);
    }
}
