package model.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "id")
    private Menu menu;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Reservation reservation;

    public Dish(int id, String title, String description, Menu menu) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.menu = menu;
    }

    public Dish(String title, String description, Menu menu) {
        this.title = title;
        this.description = description;
        this.menu = menu;
    }

    public Dish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "\n__________________________________________________\n" +
                "BOOK id: " + id +
                "\ntitle: " + title + '\'' +
                "\ndescription: " + description + '\'' +
                "\nmenu: " + menu;
    }
}
