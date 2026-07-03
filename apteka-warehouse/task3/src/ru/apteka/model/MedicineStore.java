package ru.apteka.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Простейший слой Model (без базы данных) для задания 2.
 * Хранит список лекарств в памяти приложения и предоставляет
 * операции чтения, добавления и редактирования данных.
 * В задании 4 будет заменён на JPA-сущность + EJB-компонент,
 * работающие с реальной базой данных MySQL.
 */
public class MedicineStore {

    private static final List<Medicine> items = new ArrayList<>();
    private static int nextId = 1;

    static {
        // стартовые данные
        add(new Medicine(0, "Парацетамол 500мг №20", "Фармстандарт", 150, 45.90, "2027-05-01"));
        add(new Medicine(0, "Ибупрофен 400мг №30", "Верофарм", 80, 89.50, "2026-11-15"));
        add(new Medicine(0, "Аскорбиновая кислота №50", "Фармаприм", 200, 25.00, "2027-01-20"));
    }

    public static synchronized List<Medicine> getAll() {
        return items;
    }

    public static synchronized Medicine getById(int id) {
        for (Medicine m : items) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public static synchronized Medicine add(Medicine m) {
        m.setId(nextId++);
        items.add(m);
        return m;
    }

    public static synchronized boolean update(Medicine updated) {
        Medicine existing = getById(updated.getId());
        if (existing == null) return false;
        existing.setName(updated.getName());
        existing.setManufacturer(updated.getManufacturer());
        existing.setQuantity(updated.getQuantity());
        existing.setPrice(updated.getPrice());
        existing.setExpiryDate(updated.getExpiryDate());
        return true;
    }

    public static synchronized boolean delete(int id) {
        return items.removeIf(m -> m.getId() == id);
    }
}
