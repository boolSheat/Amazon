package repo;

import Exceptions.NoSuchCategoryExistsException;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {
    private final List<Product> products = new ArrayList<>();
    private final Map<String, List> categoryVsProductsMap = new HashMap<>();
    private static ProductRepo productRepo;

    private ProductRepo() {
    }

    public static ProductRepo getProductRepoSingletonInstance(){
        if(productRepo==null) {
            productRepo = new ProductRepo();
        }
        return productRepo;
    }

    public List<Product> getProducts() {

        return products;
    }

    public List<Product> getProductsByCategory(String category) {
        if(categoryVsProductsMap.containsKey(category)) {
            System.out.println("Getting products by for category: " + category);
            return categoryVsProductsMap.get(category);
        }
        else {
            throw new NoSuchCategoryExistsException();
        }
    }

    public void addNewCategory(String category) {
        categoryVsProductsMap.put(category, new ArrayList<>());
    }

    public void addProduct(Product product) {
        products.add(product);
        if(!categoryVsProductsMap.containsKey(product.getProductCategory())) {
            addNewCategory(product.getProductCategory());
        }
        System.out.println("Adding product: " + product.getProductName());
        categoryVsProductsMap.get(product.getProductCategory()).add(product);
    }

    public void deleteProduct(Product product) {
        System.out.println("Removing product: " + product.getProductName());
        products.remove(product);
        categoryVsProductsMap.get(product.getProductCategory()).remove(product);
    }

    public Product getProductByName(String productName) {
        return products.stream().filter(product -> product.getProductName().equals(productName)).findFirst().get();
    }

}
