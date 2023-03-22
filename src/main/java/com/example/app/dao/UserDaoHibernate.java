package com.example.app.dao;

import com.example.app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoHibernate implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User fineOne(Long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User updatedUser) {
        User changed = entityManager.find(User.class, id);
        changed.setAge(updatedUser.getAge());
        changed.setName(updatedUser.getName());
        entityManager.persist(changed);
    }

    @Override
    public void delete(Long id) {
        entityManager.createQuery("DELETE FROM User user WHERE user.id =: getId").setParameter("getId", id).executeUpdate();
    }
}
