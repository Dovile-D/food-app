package model.dao;

import model.entity.Menu;
import model.entity.Reservation;
import model.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class ReservationDAO {

    public static void insert(Reservation reservation) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(reservation);
        transaction.commit();
    }

    public boolean getReservationStatus(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Reservation reservation = this.searchById(id);
        session.getTransaction().commit();
        return reservation.getIsConfirmed();
    }

    public static Reservation searchById(int id) {
        Transaction transaction = null;
        Reservation reservation = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        reservation = session.get(Reservation.class, id);
        transaction.commit();

        return reservation;
    }

    public static void deleteById(int id) {
        Transaction transaction = null;
        Reservation reservation = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        reservation = session.get(Reservation.class, id);
        session.delete(reservation);
        transaction.commit();
    }

}
