package services.phc;

import dao.phc.PHCHibernateDAO;
import entity.hibirnated.ProductHasCategory;

import java.util.List;

public class PHCService implements IPHCService{
    private final PHCHibernateDAO phcHibernateDAO = new PHCHibernateDAO();

    public void createPHC(ProductHasCategory phc) {
        phcHibernateDAO.create(phc);
    }

    public ProductHasCategory findPHC(int phcId) {
        return phcHibernateDAO.findById(phcId);
    }

    public void updatePHC(ProductHasCategory phc) {
        phcHibernateDAO.saveOrUpdate(phc);
    }

    public void deletePHC(int phcId) {
        phcHibernateDAO.delete(phcId);
    }

    public void deletePHC(ProductHasCategory phc) {
        phcHibernateDAO.delete(phc);
    }

    public List<ProductHasCategory> getAllPHC() {
        return phcHibernateDAO.findAll();
    }

    public List<ProductHasCategory> findByIdProduct(int id) {return phcHibernateDAO.getByIdProduct(id);}
}
