package miniProject.lionGym.people;

/**
 * 트레이너 클래스
 * @author dahee
 * @since 25.08.30
 */
public class Trainer extends Person implements PayRule{
    private int baseSalary; // 기본급
    private int bonus;      // 수업당 성과금
    private int lessons;    // 이번달 수업횟수

    public Trainer() {
    }

    public Trainer(String id, String name, String phone, int baseSalary, int bonus, int lessons) {
        super(id, name, phone);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.lessons = lessons;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getLessons() {
        return lessons;
    }

    public void setLessons(int lessons) {
        this.lessons = lessons;
    }

    @Override
    public int calculatePay() {
        return baseSalary + (lessons * bonus);
    }

    public void addLesson() {
        lessons++;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "baseSalary=" + baseSalary +
                ", bonus=" + bonus +
                ", lessons=" + lessons +
                '}';
    }
}
