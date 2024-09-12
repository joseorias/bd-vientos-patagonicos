package tp.api;

import java.util.List;

import tp.model.Product;

public interface ProductService {
    void create_product(String code, String brand, String description, double price, int id_category);

    void update_product(int id, String code, String brand, String description, double price, int id_category);

    List<Product> list_products();
}
