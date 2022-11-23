package pl.coderslab.finalproject.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.finalproject.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void create(Category item) {
        entityManager.persist(item);
    }

    public Category update(Category item) {
        return entityManager.merge(item);
    }

    public void remove(Category item) {
        entityManager.remove(entityManager.contains(item) ? item : entityManager.merge(item));
    }
}