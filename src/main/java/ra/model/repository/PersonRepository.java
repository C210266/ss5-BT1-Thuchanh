package ra.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ra.model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.config.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();
        TypedQuery<Person> type = entityManager.createQuery("SELECT p from Person as p", Person.class);
        list = type.getResultList();
        return list;
    }

    @Override
    public Person findByID(Long id) {
        TypedQuery<Person> type = entityManager.createQuery("select p from Person p where p.id = :id", Person.class);
        type.setParameter("id", id);
        Person p = type.getSingleResult();
        return p;

    }

    @Override
    public void save(Person p) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (p.getId() == null) {
                session.save(p);
            } else {
                Person old = findByID(p.getId());
                if (p.getAvatar() == null) {
                    p.setAvatar(old.getAvatar());
                }
                old.copy(p);
                session.saveOrUpdate(old);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction != null){
                transaction.isActive();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public void delete(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(findByID(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
