package dao.phc;

import dao.AbstractGenericDao;
import entity.hibirnated.Comments;
import entity.hibirnated.ProductHasCategory;

import java.util.List;

public class PHCHibernateDAO
        extends AbstractGenericDao<ProductHasCategory> implements PHCDAO{
    public List<ProductHasCategory> getByIdProduct(int id) {
        openTransaction();
        List<ProductHasCategory> results = getEm().createNamedQuery("ProductHasCategory.findByProduct", ProductHasCategory.class)
                .setParameter("id", id)
                .getResultList();
        closeTransaction();
        return results;
    }
}
