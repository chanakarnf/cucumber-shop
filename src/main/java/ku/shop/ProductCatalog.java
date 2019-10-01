package ku.shop;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

    private Map<String, Product> products;


    public ProductCatalog() {
        products = new HashMap<>();
    }

    public void addProduct(String name, double price,int num) {
        products.put(name, new Product(name, price,num));

    }


    public Product getProduct(String name) {
        return products.get(name);
    }
}
