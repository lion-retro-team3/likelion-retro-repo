package lionjdbc.ProductsExample;

import java.time.LocalDate;
import java.util.Date;

public class ProductsMainTest {
    public static void main(String[] args) {
        ProductsDAO productsDAO = new ProductsDAO();
        ProductsDTO productsDTO = new ProductsDTO();
        productsDTO.setName("연필");
        productsDTO.setPrice(1500);
        productsDTO.setReg_date(LocalDate.now());
        int result = productsDAO.insertProducts(productsDTO);
        if (result == 1) {
            System.out.println("상품 등록 성공: " + productsDTO);
        } else {
            System.out.println("상품 등록 실패");
        }
    }
}
