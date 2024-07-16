package web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepo {

    @Autowired
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void createUser(User user) {
        em.persist(user);
    }

    @Transactional
    public void deleteUser(int id) {
        em.remove(em.getReference(User.class, id));
    }

    @Transactional
    public void updateUser(User user) {
        em.merge(user);
    }
}
