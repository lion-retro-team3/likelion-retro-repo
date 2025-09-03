package Mini_Project.Restaurant;

public class Menu_Item {
    private String name;
    private int price;
    Menu_Item(String name, int price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString(){
        return "("+name+","+price+")";
    }
}
