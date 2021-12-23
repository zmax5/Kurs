package entity.hibirnated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vendor implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idVendor")
    private int idVendor;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Phone")
    private String phone;
    @OneToMany(mappedBy = "vendorByIdVendor")
    private Collection<Product> productsByIdVendor;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendor vendor = (Vendor) o;
        return idVendor == vendor.idVendor && Objects.equals(name, vendor.name) && Objects.equals(phone, vendor.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVendor, name, phone);
    }

    public Collection<Product> getProductsByIdVendor() {
        return productsByIdVendor;
    }

    public void setProductsByIdVendor(Collection<Product> productsByIdVendor) {
        this.productsByIdVendor = productsByIdVendor;
    }
}
