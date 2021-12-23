package entity.hibirnated;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Comments.findAll",
                query = "SELECT c FROM Comments c"),
        @NamedQuery(name = "Comments.findById",
                query = "SELECT c FROM Comments c WHERE c.idComments = :id"),
        @NamedQuery(name = "Comments.findByProduct",
                query = "SELECT c FROM Comments c WHERE c.idProduct = :id"),
})
public class Comments implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idComments")
    private int idComments;
    @Basic
    @Column(name = "comm_idProduct")
    private int idProduct;
    @Basic
    @Column(name = "Nick")
    private String nick;
    @Basic
    @Column(name = "Text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "comm_idProduct", referencedColumnName = "idProduct", nullable = false,  insertable = false, updatable = false)
    private Product productByIdProduct;

    public int getIdComments() {
        return idComments;
    }

    public void setIdComments(int idComments) {
        this.idComments = idComments;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return idComments == comments.idComments && idProduct == comments.idProduct && Objects.equals(nick, comments.nick) && Objects.equals(text, comments.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComments, idProduct, nick, text);
    }

    public Product getProductByIdProduct() {
        return productByIdProduct;
    }

    public void setProductByIdProduct(Product productByIdProduct) {
        this.productByIdProduct = productByIdProduct;
    }
}
