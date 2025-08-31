package day08;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee m = new Manager("Alice", 101, 3_000_000,38,500_000, 8);
        Employee d = new Developer("Bob", 102, 3_000_000, 22, new String[]{"Java","SQL"}, 4);
        Employee i = new Intern("Tom", 103, 2_000_000, 1,2,5);

        m.displayInfo();
        System.out.println("=========================");
        d.displayInfo();
        System.out.println("=========================");
        i.displayInfo();
    }
}
