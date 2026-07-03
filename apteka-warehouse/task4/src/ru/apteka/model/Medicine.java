package ru.apteka.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * JPA-сущность "Лекарство". Отображается на таблицу medicine
 * в базе данных MySQL. JPA-контейнер (реализация — EclipseLink,
 * встроенная в GlassFish) выполняет объектно-реляционное
 * отображение экземпляров этого класса на строки таблицы.
 */
@Entity
@Table(name = "medicine")
public class Medicine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "manufacturer", length = 150)
    private String manufacturer;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "expiry_date")
    private String expiryDate;

    public Medicine() {
    }

    public Medicine(String name, String manufacturer, int quantity, double price, String expiryDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
}
