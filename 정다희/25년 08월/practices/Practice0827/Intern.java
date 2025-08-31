package day08;

// Intern 클래스
public class Intern extends Employee {
    private int contractTerm;
    private int overtimeHours;

    public Intern(String name, int id, double baseSalary, int serviceMonths,
                  int contractTerm, int overtimeHours) {
        super(name, id, baseSalary, serviceMonths);
        this.contractTerm = contractTerm;
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (overtimeHours * 15000);
    }

    @Override
    public String getRole() {
        return "Intern (계약기간: " + contractTerm + "개월)";
    }
}
