package Utils;

import java.util.Properties;

public class Product {

    private final String productName;
    private final String wrongProductName;

    public Product(Properties properties) {
        productName = properties.getProperty("product.productName");
        wrongProductName = properties.getProperty("product.wrongProductName");
    }

    public String getProductName() {
        return productName;
    }

    public String getWrongProductName() {
        return wrongProductName;
    }

}
