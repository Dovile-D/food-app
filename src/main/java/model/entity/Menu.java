package model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Dish> dishes;
    @ManyToOne
    @JoinColumn(name = "food_provider_id")
    private FoodProvider foodProvider;

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public FoodProvider getFoodProvider() {
        return foodProvider;
    }

    public void setFoodProvider(FoodProvider foodProvider) {
        this.foodProvider = foodProvider;
    }

    @Override
    public String toString() {
        return "_____________________________" +
                "MENU id:" + id +
                "\nmenu name: " + name + '\'' +
                "\ndishes: " + dishes +
                "\nfoodProvider: " + foodProvider;
    }
}
