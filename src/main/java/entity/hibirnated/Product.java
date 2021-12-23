package entity.hibirnated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Product.findAll",
                query = "SELECT p FROM Product p"),
        @NamedQuery(name = "Product.findById",
                query = "SELECT p FROM Product p WHERE p.idProduct = :id"),
        @NamedQuery(name = "Product.findByVendor",
                query = "SELECT p FROM Product p WHERE p.idVendor = :id"),
})
public class Product implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProduct")
    private int idProduct;
    @Basic
    @Column(name = "vend_idVendor")
    private int idVendor;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Descr")
    private String descr;
    @OneToMany(mappedBy = "productByIdProduct")
    private Collection<Comments> commentsByIdProduct;
    @ManyToOne
    @JoinColumn(name = "vend_idVendor", referencedColumnName = "idVendor", nullable = false,  insertable = false, updatable = false)
    private Vendor vendorByIdVendor;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && idVendor == product.idVendor && Objects.equals(name, product.name) && Objects.equals(descr, product.descr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idVendor, name, descr);
    }

    public Collection<Comments> getCommentsByIdProduct() {
        return commentsByIdProduct;
    }

    public void setCommentsByIdProduct(Collection<Comments> commentsByIdProduct) {
        this.commentsByIdProduct = commentsByIdProduct;
    }

    public Vendor getVendorByIdVendor() {
        return vendorByIdVendor;
    }

    public void setVendorByIdVendor(Vendor vendorByIdVendor) {
        this.vendorByIdVendor = vendorByIdVendor;
    }

}
