package repository;

import product.Alcohol;
import product.Beverage;
import product.Product;
import product.Snack;

import java.util.Map;
import java.util.Random;

public class ProductRepo {

    public static void initTestProduct(Map<Long, Product> map){
        Product product = null;
        Random random = new Random();

        for (int i =0; i< 30; i++){
            int price = random.nextInt(5000) + 1;
            int stock = random.nextInt(100) + 1;
            if (i < 10)  product= new Snack("test"+i,price,stock);
            else if (i <20) {
                product = new Beverage("test"+i,price,stock);
            } else if (i < 30) {
                product = new Alcohol("test"+i,price,stock);
            }
            if (product != null) map.put(product.getCode(),product);

        }

    }

}
