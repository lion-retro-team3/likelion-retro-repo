package day08;

// Developer 클래스
public class Developer extends Employee {
    private String[] skills;
    private int projectCount;

    public Developer(String name, int id, double baseSalary, int serviceMonths,
                     String[] skills, int projectCount) {
        super(name, id, baseSalary, serviceMonths);
        this.skills = skills;
        this.projectCount = projectCount;
    }

    @Override
    public double calculateSalary() {
        // 프로젝트당 보너스
        return baseSalary + (projectCount * 100000);
    }

    @Override
    public String getRole() {
        return "Developer (" + String.join(", ", skills) + ")";
    }
}
