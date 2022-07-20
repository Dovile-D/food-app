package model.dao;

import model.entity.Menu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class MenuDAO {

    public static void insert(Menu menu) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(menu);
        transaction.commit();
    }

    public static Menu searchById(int id) {
        Transaction transaction = null;
        Menu menu = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        menu = session.get(Menu.class, id);
        transaction.commit();

        return menu;
    }

    public static void deleteById(int id) {
        Transaction transaction = null;
        Menu menu = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        menu = session.get(Menu.class, id);
        session.delete(menu);
        transaction.commit();
    }

    public static void update(Menu menu) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.update(menu);
        transaction.commit();
    }

    public static List<Menu> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Menu> menus = session.createQuery("FROM Menu e WHERE e.name = " + name).getResultList();
        transaction.commit();

        return menus;
    }

    public static List<Menu> searchAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Menu> menus = null;
        menus = session.createQuery("FROM Menu").list();

        return menus;
    }
}
