package com.jiro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Repository
public class GenericDao {

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    protected Session getCurrentSession() {
//        return sessionFactory.getCurrentSession();
//    }


    @PersistenceContext
    EntityManager entityManager;

    protected Session getCurrentSession()  {
        return entityManager.unwrap(Session.class);
    }

    @Transactional
    public Object get(Class<?> c, Serializable value) {
        try {
            return c.cast(getCurrentSession().get(c, value));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public void save(Object pojoObject) {
        try {
            getCurrentSession().save(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void saveOrUpdate(Object pojoObject) {
        try {
            getCurrentSession().saveOrUpdate(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public long persist(Object pojoObject) {
        try {
            return (long) getCurrentSession().save(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Transactional
    public void delete(Object pojoObject) {
        try {
            getCurrentSession().delete(pojoObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public List<?> getList(Class<?> c) {
        return getCurrentSession().createCriteria(c).list();
    }

}