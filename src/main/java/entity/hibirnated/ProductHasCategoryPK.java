package entity.hibirnated;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductHasCategoryPK implements Serializable {
    @Column(name = "categ_idCategory")
    @Id
    private int categIdCategory;
    @Column(name = "prod_idProduct")
    @Id
    private int prodIdProduct;

    public int getCategIdCategory() {
        return categIdCategory;
    }

    public void setCategIdCategory(int categIdCategory) {
        this.categIdCategory = categIdCategory;
    }

    public int getProdIdProduct() {
        return prodIdProduct;
    }

    public void setProdIdProduct(int prodIdProduct) {
        this.prodIdProduct = prodIdProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductHasCategoryPK that = (ProductHasCategoryPK) o;
        return categIdCategory == that.categIdCategory && prodIdProduct == that.prodIdProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categIdCategory, prodIdProduct);
    }
}
