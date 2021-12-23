package dao.property;

import dao.AbstractGenericDao;
import entity.hibirnated.Property;

import java.util.List;

public class PropertyHibernateDAO
        extends AbstractGenericDao<Property> implements PropertyDAO{

    public List<Property> getByIdProduct(int id) {
        openTransaction();
        List<Property> results = getEm().createNamedQuery("Property.findByProduct", Property.class)
                .setParameter("id", id)
                .getResultList();
        closeTransaction();
        return results;
    }
}
