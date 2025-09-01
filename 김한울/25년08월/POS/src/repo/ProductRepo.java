package repo;

import product.Alcohol;
import product.Beverage;
import product.Product;
import product.Snack;

import java.util.Map;

public class ProductRepo {


    public static void initTestProduct(Map<Long, Product> map){
        Product product = null;
        for (int i =0; i< 30; i++){
            if (i < 10)  product= new Snack("test"+i,10+i*10,i);
            else if (i <20) {
                product = new Beverage("test"+i,i*10,i);
            } else if (i < 30) {
                product = new Alcohol("test"+i,i*10,i);
            }
            if (product != null) map.put(product.getCode(),product);

        }

    }

}
