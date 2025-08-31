package order;

import product.Product;

public class OrderService {


    public boolean isInvalidProduct(Product product){
        return product == null;
    }

    public boolean isInvalidQuantity(int orderQuantity,int productQuantity){

        return orderQuantity >0 && productQuantity < orderQuantity;
    }



}
