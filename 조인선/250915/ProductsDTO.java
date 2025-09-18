package lionjdbc.ProductsExample;
import java.sql.Date;
import java.time.LocalDate;

public class ProductsDTO {
    private String name;
    private int price;
    private LocalDate reg_date;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getReg_date() {
        return reg_date;
    }

    public void setReg_date(LocalDate reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                ", name='" + name + '\'' +
                ", price ='" + price + '\'' +
                ", reg_date=" + reg_date +
                '}';
    }
}