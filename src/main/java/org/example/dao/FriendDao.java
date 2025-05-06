package org.example.dao;

import org.example.models.Friends;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.utils.HibernateSessionFactoryUtil;
import java.util.List;

public class FriendDao {

    public Friends findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Friends.class, id);
    }

    public void save(Friends friend) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.merge(friend);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            tx1.rollback();
            session.close();
        }
    }

    public void update(Friends friend) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(friend);
        tx1.commit();
        session.close();
    }

    public void delete(Friends friend) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.delete(friend);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            tx1.rollback();
            session.close();
        }
    }

    public Friends findFriendById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Friends.class, id);
    }

    public List<Friends> findAll() {
        List<Friends> friends = (List<Friends>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Friends").list();
        return friends;
    }
}