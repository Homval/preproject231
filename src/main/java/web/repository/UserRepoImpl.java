package web.repository;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        em.remove(em.getReference(User.class, id));
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }
}
