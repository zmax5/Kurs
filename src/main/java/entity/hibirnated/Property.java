package entity.hibirnated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Property.findAll",
                query = "SELECT p FROM Property p"),
        @NamedQuery(name = "Property.findById",
                query = "SELECT p FROM Property p WHERE p.idProperty = :id"),
        @NamedQuery(name = "Property.findByProduct",
                query = "SELECT p FROM Property p WHERE p.idProduct = :id"),
})
public class Property implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProperty")
    private int idProperty;
    @Basic
    @Column(name = "prop_idProduct")
    private int idProduct;
    @Basic
    @Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "prop_idProduct", referencedColumnName = "idProduct", nullable = false,  insertable = false, updatable = false)
    private Product productByIdProduct;

    public int getIdProperty() {
        return idProperty;
    }

    public void setIdProperty(int idProperty) {
        this.idProperty = idProperty;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return idProperty == property.idProperty && idProduct == property.idProduct && Objects.equals(name, property.name) && Objects.equals(value, property.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProperty, idProduct, name, value);
    }

    public Product getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(Product productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }
}
