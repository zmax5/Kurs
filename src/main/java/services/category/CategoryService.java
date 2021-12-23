package services.category;

import dao.category.CategoryHibernateDAO;
import entity.hibirnated.Category;

import java.util.List;

public class CategoryService implements ICategoryService {

    private CategoryHibernateDAO categoryHibernateDAO = new CategoryHibernateDAO();

    public void createCategory(Category category) {
        categoryHibernateDAO.create(category);
    }

    public Category findCategory(int categoryId) {
        return categoryHibernateDAO.findById(categoryId);
    }

    public void updateCategory(Category category) {
        categoryHibernateDAO.saveOrUpdate(category);
    }

    public void deleteCategory(int categoryId) {
        categoryHibernateDAO.delete(categoryId);
    }

    public List<Category> getAllCategory() {
        return categoryHibernateDAO.findAll();
    }

    public List<Category> getByIdProduct(int idProduct) {
        return categoryHibernateDAO.getByIdProduct(idProduct);
    }

}
