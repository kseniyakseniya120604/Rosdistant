package ru.apteka.model;

import java.io.Serializable;

/**
 * JavaBean "Лекарство" — модель (Model) предметной области "Аптечный склад".
 * Хранит данные об одной позиции склада.
 */
public class Medicine implements Serializable {

    private int id;
    private String name;          // наименование
    private String manufacturer;  // производитель
    private int quantity;         // количество на складе, шт.
    private double price;         // цена за упаковку, руб.
    private String expiryDate;    // срок годности (гггг-мм-дд)

    public Medicine() {
    }

    public Medicine(int id, String name, String manufacturer, int quantity, double price, String expiryDate) {
        this.id = id;
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
