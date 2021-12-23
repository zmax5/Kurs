package dao.category;

import dao.AbstractGenericDao;
import dao.phc.PHCHibernateDAO;
import entity.hibirnated.Category;
import entity.hibirnated.ProductHasCategory;
import services.category.CategoryService;
import services.phc.PHCService;

import java.util.ArrayList;
import java.util.List;

public class CategoryHibernateDAO
        extends AbstractGenericDao<Category> implements CategoryDAO {

    public List<Category> getByIdProduct(int id) {
        List<Category> result = new ArrayList<>();
        List<ProductHasCategory> phcs = new PHCHibernateDAO().findAll();
        for (ProductHasCategory phc : phcs) {
            if (phc.getProdIdProduct() == id){
                result.add(findById(phc.getCategIdCategory()));
            }
        }
        return result;
    }
}
