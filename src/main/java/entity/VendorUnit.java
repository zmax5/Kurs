package entity;

import entity.hibirnated.Vendor;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;

public class VendorUnit implements Serializable {
    private int idVendor;
    private String name;
    private String phone;

    public VendorUnit(Vendor vendor) {
        this.idVendor = vendor.getIdVendor();
        this.name = vendor.getName();
        this.phone = vendor.getPhone();
    }

    public int getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(int idVendor) {
        this.idVendor = idVendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
