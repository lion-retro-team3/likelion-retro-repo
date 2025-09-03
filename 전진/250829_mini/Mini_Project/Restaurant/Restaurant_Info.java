package Mini_Project.Restaurant;

import java.util.List;

public class Restaurant_Info {
    private String Restaurant_name;
    //String Restaurant_address;
    //String Restaurant_phone;
    private List<Menu_Item> MenuList;

    public Restaurant_Info(String Restaurant_name, List<Menu_Item> MenuList) {
        this.Restaurant_name = Restaurant_name;
        this.MenuList = MenuList;
    }

    public String getRestaurant_name() {
        return Restaurant_name;
    }

    public List<Menu_Item> getMenuList() {
        return MenuList;
    }

    public String toString(){

        return null;
    }
}
