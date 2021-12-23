package entity;

import entity.hibirnated.Category;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;

public class CategoryUnit implements Serializable {
    private int idCategory;
    private String name;

    public CategoryUnit(Category cat) {
        this.idCategory = cat.getIdCategory();
        this.name = cat.getName();
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
