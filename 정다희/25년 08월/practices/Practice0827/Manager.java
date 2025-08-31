package day08;

// Manager 클래스
public class Manager extends Employee {
    private double bonus;
    private int teamSize;

    public Manager(String name, int id, double baseSalary, int serviceMonths,
                   double bonus, int teamSize) {
        super(name, id, baseSalary, serviceMonths);
        this.bonus = bonus;
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }

    @Override
    public String getRole() {
        return "Manager (팀원: " + teamSize + "명)";
    }
}
