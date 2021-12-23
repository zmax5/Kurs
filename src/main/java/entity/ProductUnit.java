package entity;

import entity.hibirnated.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

public class ProductUnit implements Serializable {
    private int idProduct;
    private int idVendor;
    private String name;
    private String descr;

    public ProductUnit(Product prod) {
        this.idProduct = prod.getIdProduct();
        this.idVendor = prod.getIdVendor();
        this.name = prod.getName();
        this.descr = prod.getDescr();
    }

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
}
