package entity.hibirnated;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_has_category", schema = "ne-ekat")
@IdClass(ProductHasCategoryPK.class)
@NamedQueries({
        @NamedQuery(name = "ProductHasCategory.findAll",
                query = "SELECT phc FROM ProductHasCategory phc"),
        @NamedQuery(name = "ProductHasCategory.findByProduct",
                query = "SELECT phc FROM ProductHasCategory phc WHERE phc.prodIdProduct = :id"),
})
public class ProductHasCategory {
    @Id
    @Column(name = "categ_idCategory")
    private int categIdCategory;
    @Id
    @Column(name = "prod_idProduct")
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
        ProductHasCategory that = (ProductHasCategory) o;
        return categIdCategory == that.categIdCategory && prodIdProduct == that.prodIdProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categIdCategory, prodIdProduct);
    }
}
