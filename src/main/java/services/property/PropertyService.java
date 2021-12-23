package services.property;

import dao.property.PropertyHibernateDAO;
import entity.hibirnated.Property;

import java.util.List;

public class PropertyService implements IPropertyService{

    private final PropertyHibernateDAO propertyHibernateDAO = new PropertyHibernateDAO();

    public void createProperty(Property property) {
        propertyHibernateDAO.create(property);
    }

    public Property findProperty(int propertyId) {
        return propertyHibernateDAO.findById(propertyId);
    }

    public void updateProperty(Property property) {
        propertyHibernateDAO.saveOrUpdate(property);
    }

    public void deleteProperty(int propertyId) {
        propertyHibernateDAO.delete(propertyId);
    }

    public List<Property> getAllProperty() {
        return propertyHibernateDAO.findAll();
    }

    public List<Property> getPropertyByProduct(int id) {
        return propertyHibernateDAO.getByIdProduct(id);
    }
}
