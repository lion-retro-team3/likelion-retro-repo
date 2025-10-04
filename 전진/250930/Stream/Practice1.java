package Practice.Stream;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice1 {
    public static void main(String[] args) {
        P1();
        P2();
        P3();
        P4();
        P5();
        P6();
        P7();
    }
    public static void P1() {
//        실습 문제 1: 숫자 배열 처리
//
//        주어진 정수 배열에서 짝수만을 찾아 그 합을 구하시오.
        System.out.println("======1번======");
        int[] numbers = {3, 10, 4, 17, 6};
        List<Integer> stream = Arrays.stream(numbers).filter(n->n%2==0).boxed().collect(Collectors.toList());
        int sum=Arrays.stream(numbers).filter(n->n%2==0).sum();

        System.out.println(stream);
        System.out.println(sum);

    }
    public static void P2() {
//        실습 문제 2: 문자열 리스트 필터링
//
//        주어진 문자열 리스트에서 길이가 5 이상인 문자열만을 선택하여 대문자로 변환하고, 결과를 리스트로 반환하시오.
        System.out.println("======2번======");
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> stream=words.stream().filter(n-> (n.length()>=5)).map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(stream);
    }
    public static void P3() {
//        실습 문제 3: 학생 성적 처리
//
//        학생 객체의 리스트가 주어졌을 때, 성적(score)이 80점 이상인 학생들만을 선택하고, 이들의 이름을 알파벳 순으로 정렬하여 출력하시오.
//
        System.out.println("======3번======");
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        List<String> over80=students.stream().filter(n->n.getScore()>=80).sorted(Comparator.comparing(Student::getName)).map(Student::getName).collect(Collectors.toList());
        System.out.println(over80);
    }
    public static void P4() {
//        실습 문제 4: 직원 관리
//
//        직원 객체의 리스트에서 각 부서(department)별로 평균 급여를 계산하시오.
        System.out.println("======4번======");
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );
        Map<String,Double> average=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)))
                .forEach((S,D)->System.out.println(S +" : "+D));
        System.out.println(average);
    }
    public static void P5() {
//        실습 문제 5: 제품 카테고리별 평균 가격 계산
//
//주어진 제품 리스트에서 각 카테고리별로 평균 가격을 계산하시오.
//
        System.out.println("======5번======");
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );

        products.stream().collect(Collectors.groupingBy(Product::getCategory,Collectors.averagingDouble(Product::getPrice))).forEach((S,A)->System.out.println(S +" : "+A));

        //System.out.println(average);
    }
    public static void P6() {
//        실습 문제 6: 나이대별 평균 점수 계산
//
//        학생 리스트에서 나이대별(10대, 20대 등)로 평균 점수를 계산하시오.
        System.out.println("======6번======");
        List<Student> students = Arrays.asList(
                new Student("Alice", 14, 88),
                new Student("Bob", 23, 82),
                new Student("Charlie", 17, 95),
                new Student("David", 21, 73)
        );

        Map<String,Double> average=students.stream().collect(Collectors.groupingBy(s -> s.getAge()/10 *10+"대",Collectors.averagingInt(Student::getScore)));
        System.out.println(average);
    }
    public static void P7() {
//        실습 문제 7: 도시별 최고 온도 기록
//
//        여러 도시의 일일 최고 온도가 주어졌을 때, 각 도시의 최고 온도를 찾으시오.
        System.out.println("======7번======");
        List<Temperature> temperatures = Arrays.asList(
                new Temperature("Seoul", 33),
                new Temperature("New York", 30),
                new Temperature("Seoul", 34),
                new Temperature("New York", 28)
        );

        Map<String, Integer> maxTem=temperatures.stream().collect(Collectors.groupingBy(
                Temperature::getCity, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Temperature::getMaxTemp)),t->t.get().getMaxTemp())));
        System.out.println(maxTem);
    }
}
class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}
class Temperature {
    private String city;
    private int maxTemp;

    public Temperature(String city, int maxTemp) {
        this.city = city;
        this.maxTemp = maxTemp;
    }

    public String getCity() {
        return city;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}
