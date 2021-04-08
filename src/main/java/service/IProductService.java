package service;

import Exceptions.NoSuchCategoryExistsException;
import model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAllProducts();
    public List<Product> getProductsByCategory(String category);
    public void addNewProduct(Product product);
    public void addNewCategory(String category);
    public Product getProductByName(String productName);
}
