package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;

import javax.persistence.*;
import javax.transaction.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public abstract class AbstractGenericDao<T> implements GenericDAO<T> {

    private final Class<T> entityClass;

    public AbstractGenericDao() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    private EntityManagerFactory entityManagerFactory;

    private EntityManager em;

    private EntityTransaction transaction;

    private Session session;

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(EntityTransaction transaction) {
        this.transaction = transaction;
    }

    public void openTransaction() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        em = entityManagerFactory.createEntityManager();
        session = em.unwrap(org.hibernate.Session.class);
        transaction = em.getTransaction();
        transaction.begin();
    }

    public void closeTransaction() {
        transaction.commit();
        if (transaction.isActive()) {
            transaction.rollback();
        }
        session.close();
        em.close();
        entityManagerFactory.close();
    }

    @Override
    public T findById(final Serializable id) {
        openTransaction();
        /* -- FOR EMERGENCY --
        String fullName = this.entityClass.getName();
        String name = fullName.substring(fullName.lastIndexOf(".")+1);
        T result = null;
        result = (T) em.createNamedQuery( name + ".findById")
                    .setParameter("id",id)
                    .getSingleResult();*/
        T result = session.get(this.entityClass, id);
        closeTransaction();
        return result;
    }

    @Override
    public void create(T entity) {
        openTransaction();
        //session.save(entity);
        em.persist(entity);
        closeTransaction();
    }

    @Override
    public void saveOrUpdate(T entity) {
        openTransaction();
        session.saveOrUpdate(entity);
        //em.merge(entity);
        closeTransaction();
    }

    @Override
    public void delete(T entity) {
        openTransaction();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        //session.delete(entity);
        closeTransaction();
    }

    @Override
    public void delete(final Serializable id) {
        openTransaction();
        T entity = session.get(this.entityClass, id);
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        //em.remove(findById(id));
        closeTransaction();
    }

    @Override
    public List<T> findAll() {
        openTransaction();
        /*
        String fullName = this.entityClass.getName();
        String name = fullName.substring(fullName.lastIndexOf(".")+1);
        List<T> results = (List<T>) em.createNamedQuery(name + ".findAll").getResultList();*/
        List<T> results = session.createCriteria(this.entityClass).list();
        closeTransaction();
        return results;
    }

    // GARBAGE
    @Override
    public List<T> findAllByExample(T entity) {
        Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
        openTransaction();
        List<T> result = session.createCriteria(this.entityClass).add(example).list();
        closeTransaction();
        return result;
    }

    @Override
    public void clear() {
        em.clear();
    }

    @Override
    public void flush() {
        em.flush();
    }

}