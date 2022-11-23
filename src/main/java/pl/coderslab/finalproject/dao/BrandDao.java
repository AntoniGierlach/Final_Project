package pl.coderslab.finalproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.finalproject.model.Brand;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BrandDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Brand> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Brand b");
        return query.getResultList();
    }

    public Brand findById(Long id) {
        return entityManager.find(Brand.class, id);
    }

    public void create(Brand item) {
        entityManager.persist(item);
    }

    public Brand update(Brand item) {
        return entityManager.merge(item);
    }

    public void remove(Brand item) {
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
    }
}