package org.example.dao;

import org.example.models.Cats;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.utils.HibernateSessionFactoryUtil;
import java.util.List;

public class CatDao {

    public Cats findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Cats.class, id);
    }

    public void save(Cats cat) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.merge(cat);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            tx1.rollback();
            session.close();
        }
    }

    public void update(Cats cat) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(cat);
        tx1.commit();
        session.close();
    }

    public void delete(Cats cat) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.delete(cat);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            tx1.rollback();
            session.close();
        }
    }

    public Cats findCatById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Cats.class, id);
    }

    public List<Cats> findAll() {
        List<Cats> cats = (List<Cats>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Cats").list();
        return cats;
    }
}