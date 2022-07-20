package model.dao;

import model.entity.FoodProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class FoodProviderDAO {

    public static void insert(FoodProvider foodProvider) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(foodProvider);
        transaction.commit();
    }

    public static FoodProvider searchById(int id) {
        Transaction transaction = null;
        FoodProvider foodProvider = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        foodProvider = session.get(FoodProvider.class, id);
        transaction.commit();

        return foodProvider;
    }

    public static void deleteById(int id) {
        Transaction transaction = null;
        FoodProvider foodProvider = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        foodProvider = session.get(FoodProvider.class, id);
        session.delete(foodProvider);
        transaction.commit();
    }

    public static void update(FoodProvider foodProvider) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.update(foodProvider);
        transaction.commit();
    }

    public static List<FoodProvider> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<FoodProvider> foodProviders = session.createQuery("FROM Menu e WHERE e.name = " + name).getResultList();
        transaction.commit();

        return foodProviders;
    }

    public static List<FoodProvider> searchAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<FoodProvider> foodProviders = null;
        foodProviders = session.createQuery("FROM Menu").list();

        return foodProviders;
    }
}
