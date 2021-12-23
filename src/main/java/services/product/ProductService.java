package services.product;

import dao.product.ProductHibernateDAO;
import entity.hibirnated.Product;

import java.io.Serializable;
import java.util.List;

public class ProductService implements IProductService {
    private final ProductHibernateDAO productHibernateDAO = new ProductHibernateDAO();

    public void createProduct(Product product) {
        productHibernateDAO.create(product);
    }

    public Product findProduct(Serializable productId) {
        return productHibernateDAO.findById(productId);
    }

    public void updateProduct(Product product) {
        productHibernateDAO.saveOrUpdate(product);
    }

    public void deleteProduct(int productId) {
        productHibernateDAO.delete(productId);
    }

    public List<Product> getAllProducts() {
        return productHibernateDAO.findAll();
    }

    public List<Product> findByExample(Product p) {
        return productHibernateDAO.findAllByExample(p);
    }
}
