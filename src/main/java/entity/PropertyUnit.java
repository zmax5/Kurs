package entity;

import entity.hibirnated.Property;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.io.Serializable;

public class PropertyUnit implements Serializable {
    private int idProperty;
    private int idProduct;
    private String name;
    private String value;

    public PropertyUnit(Property prop) {
        this.idProduct = prop.getIdProduct();
        this.idProperty = prop.getIdProperty();
        this.name = prop.getName();
        this.value = prop.getValue();
    }

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
}
