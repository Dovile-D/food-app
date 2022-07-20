package model.dao;


import model.entity.Dish;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class DishDAO {

    public static void insert(Dish dish) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(dish);
        transaction.commit();
    }

    public static Dish searchById(int id) {
        Transaction transaction = null;
        Dish dish = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        dish = session.get(Dish.class, id);
        transaction.commit();

        return dish;
    }

    public static void deleteById(int id) {
        Transaction transaction = null;
        Dish dish = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        dish = session.get(Dish.class, id);
        session.delete(dish);
        transaction.commit();
    }

    public static void update(Dish dish) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.update(dish);
        transaction.commit();
    }

    public static List<Dish> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Dish> dishes = session.createQuery("FROM Dish e WHERE e.title = " + name).getResultList();
        transaction.commit();

        return dishes;
    }

    public static List<Dish> searchAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Dish> dishes = null;
        dishes = session.createQuery("FROM Dish").list();

        return dishes;
    }

    public static List<Dish> searchAvailableBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Dish> dishes = null;
        dishes = session.createQuery("FROM Dish e where e.reservation = null").list();

        return dishes;
    }
}
