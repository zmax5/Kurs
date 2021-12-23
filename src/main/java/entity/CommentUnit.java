package entity;

import entity.hibirnated.Comments;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;

public class CommentUnit implements Serializable {
    private int idComments;
    private int idProduct;
    private String nick;
    private String text;

    public CommentUnit(Comments comm) {
        this.idComments = comm.getIdComments();
        this.idProduct = comm.getIdProduct();
        this.nick = comm.getNick();
        this.text = comm.getText();
    }

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
}
