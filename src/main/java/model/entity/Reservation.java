package model.entity;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @OneToOne(mappedBy = "id")
    private User user;
    @OneToOne(mappedBy = "id")
    private Dish dish;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    public Reservation(User currentUser, Dish pickedDish) {
    }

    public Reservation(boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public Reservation(int id, User user, Dish dish, int quantity) {
        this.id = id;
        this.user = user;
        this.dish = dish;
        this.quantity = quantity;
    }

    public Reservation(User user, Dish dish, int quantity) {
        this.user = user;
        this.dish = dish;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(boolean confirmed) {
        this.isConfirmed = confirmed;
    }

    @Override
    public String toString() {
        return "_________________________" +
                "Reservation id: " + id +
                "\nuser: " + user +
                "\ndish=" + dish +
                "\nquantity=" + quantity +
                "\nisConfirmed=" + isConfirmed;
    }
}
