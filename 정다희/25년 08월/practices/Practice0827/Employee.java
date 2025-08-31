package day08;

// 추상 클래스
public abstract class Employee {
    protected String name; // 이름
    protected int id; // id
    protected double baseSalary; // 기본급여
    protected int serviceMonths; // 근속월수

    public Employee(String name, int id, double baseSalary, int serviceMonths) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.serviceMonths = serviceMonths;
    }

    // 추상 메서드
    public abstract double calculateSalary();
    public abstract String getRole();

    // 공통 메서드
    public final int getLeaveDay() {
        if (serviceMonths < 0) throw new IllegalArgumentException("months < 0");
        if (serviceMonths >= 120) return 20; // ≥ 10년 이상
        if (serviceMonths >= 60)  return 17; // ≥ 5년 이상
        if (serviceMonths >= 36)  return 16; // ≥ 3년 이상
        if (serviceMonths >= 12)  return 15; // ≥ 1년 이상
        return serviceMonths; // 1년 미만
    };

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("이름: " + name);
        System.out.println("직책: " + getRole());
        System.out.println("급여: " + calculateSalary());
        System.out.println("연차: " + getLeaveDay());
    }
}
