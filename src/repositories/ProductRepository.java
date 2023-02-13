/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repositories;

import entities.Product;
import java.util.List;

/**
 *
 * @author user
 */
public interface ProductRepository {
    List<Product> allProduct();
    Product searchProductByRef(String ref);
    Product searchProductByName(String name);
    List<Product> searchProductByPriceRange(double minPrice, double maxPrice);
    Product updateProduct(String ref);
    void addProduct(Product p);
    void deleteProduct(String ref);
    // String toString(Product p);
}
