package entity.hibirnated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Category.findAll",
                query = "SELECT c FROM Category c"),
        @NamedQuery(name = "Category.findById",
                query = "SELECT c FROM Category c WHERE c.idCategory = :id"),
})
public class Category implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idCategory")
    private int idCategory;
    @Basic
    @Column(name = "Name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return idCategory == category.idCategory && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategory, name);
    }

}
