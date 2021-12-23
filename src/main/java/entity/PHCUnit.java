package entity;

import entity.hibirnated.Category;
import entity.hibirnated.Product;
import entity.hibirnated.ProductHasCategory;

import java.io.Serializable;

public class PHCUnit implements Serializable {
    private Category category;
    private Product product;

    public PHCUnit(ProductHasCategory phc) {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
