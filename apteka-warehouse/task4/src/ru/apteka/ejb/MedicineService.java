package ru.apteka.ejb;

import ru.apteka.model.Medicine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Сессионный EJB-компонент (без сохранения состояния — @Stateless).
 * Инкапсулирует бизнес-логику работы с лекарствами и обращается
 * к базе данных через JPA EntityManager, который внедряется
 * контейнером GlassFish (EJB-контейнер) автоматически.
 */
@Stateless
public class MedicineService {

    @PersistenceContext(unitName = "AptekaPU")
    private EntityManager em;

    public List<Medicine> getAll() {
        return em.createQuery("SELECT m FROM Medicine m ORDER BY m.id", Medicine.class)
                .getResultList();
    }

    public Medicine getById(int id) {
        return em.find(Medicine.class, id);
    }

    public Medicine add(Medicine m) {
        em.persist(m);
        return m;
    }

    public Medicine update(Medicine m) {
        return em.merge(m);
    }

    public void delete(int id) {
        Medicine m = em.find(Medicine.class, id);
        if (m != null) {
            em.remove(m);
        }
    }
}
