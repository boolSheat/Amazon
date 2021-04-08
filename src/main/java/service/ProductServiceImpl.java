package service;

import model.Product;
import repo.ProductRepo;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    private ProductRepo productRepo;
    private static ProductServiceImpl productServiceImpl;

    private ProductServiceImpl() {
        this.productRepo = ProductRepo.getProductRepoSingletonInstance();
    }

    public static ProductServiceImpl getProductServiceImplSingletonInstance() {
        if(productServiceImpl==null) {
            productServiceImpl = new ProductServiceImpl();
        }
        return productServiceImpl;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.getProducts();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepo.getProductsByCategory(category);
    }

    @Override
    public void addNewProduct(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public void addNewCategory(String category) {
        productRepo.addNewCategory(category);
    }

    @Override
    public Product getProductByName(String productName) {
        return productRepo.getProductByName(productName);
    }
}
