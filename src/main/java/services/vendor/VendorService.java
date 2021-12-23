package services.vendor;

import dao.vendor.VendorHibernateDAO;
import entity.hibirnated.Vendor;

import java.util.List;

public class VendorService implements IVendorService{
    private final VendorHibernateDAO vendorHibernateDAO = new VendorHibernateDAO();

    public void createVendor(Vendor vendor) {
        vendorHibernateDAO.create(vendor);
    }

    public Vendor findVendor(int vendorId) {
        return vendorHibernateDAO.findById(vendorId);
    }

    public void updateVendor(Vendor vendor) {
        vendorHibernateDAO.saveOrUpdate(vendor);
    }

    public void deleteVendor(int vendorId) {
        vendorHibernateDAO.delete(vendorId);
    }

    public List<Vendor> getAllVendor() {
        return vendorHibernateDAO.findAll();
    }
}
