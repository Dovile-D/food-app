package model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "food_providers")
public class FoodProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "registration_no")
    private int registrationNumber;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Menu> menus;


    public FoodProvider(int id, String name, int registrationNumber, String address) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.address = address;
    }

    public FoodProvider(String name, int registrationNumber, String address) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.address = address;
    }

    public FoodProvider() {
    }

    public FoodProvider(int id, String name, int registrationNumber, String address, List<Menu> menus) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.address = address;
        this.menus = menus;
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

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "_____________________________________________________________________" +
                "FoodProvider id:" + id +
                "\nname: " + name + '\'' +
                "\nregistration number: " + registrationNumber +
                "\naddress: " + address;
    }
}
