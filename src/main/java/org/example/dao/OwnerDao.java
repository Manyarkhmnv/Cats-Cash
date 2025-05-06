package org.example.dao;

import org.example.models.Cats;
import org.example.models.Owners;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.utils.HibernateSessionFactoryUtil;
import java.util.List;

public class OwnerDao {

    public Owners findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Owners.class, id);
    }

    public void save(Owners user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.merge(user);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            tx1.rollback();
            session.close();
        }
    }

    public void update(Owners user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(Owners user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.delete(user);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            tx1.rollback();
            session.close();
        }
    }

    public Cats findOwnerById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Cats.class, id);
    }

    public List<Owners> findAll() {
        List<Owners> users = (List<Owners>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Owners").list();
        return users;
    }
}