import model.dao.*;
import model.entity.Dish;
import model.entity.Menu;
import model.entity.Reservation;
import model.entity.User;
import utils.HibernateUtil;

import java.util.Scanner;

public class




Main {
    public static void main(String[] args) {

        String loginOrReg;
        String logUsername;
        String logPassword;
        String regUsername;
        String regEmail;
        String regPassword;
        int currentUserId;
        UserDAO userDAO = new UserDAO();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat you would like to do?:\n" +
                    "1. For login.\n" +
                    "2. For register.\n" +
                    "Please select a number for operation:\n");
            loginOrReg = scan.next();
            if (loginOrReg.contains("1")) {
                System.out.println("Enter your username:");
                logUsername = scan.next();
                System.out.println("Enter your password:");
                logPassword = scan.next();
// ___________________validacija_____________________________________
                currentUserId = userDAO.findUserByUsername(logUsername).getId();

                if (userDAO.login(logUsername, logPassword)) {
                    if (userDAO.getUserRole(logUsername) == false) {
                        userFunc(currentUserId);
                    } else {
                        adminFunc();
                    }
                }
//_______________________________________________________________________________________
            } else if (loginOrReg.contains("2")) {
                System.out.println("Create your username:");
                regUsername = scan.next();
                System.out.println("Create your email:");
                regEmail = scan.next();
                System.out.println("Create your password:");
                regPassword = scan.next();
                userDAO.register(regUsername, regEmail, false, regPassword);
            }
            HibernateUtil.getSessionFactory().close();
            break;
        }
    }


    public static void adminFunc() {
        while (true) {
            DishDAO dishDAO = new DishDAO();
            FoodProviderDAO foodProviderDAO = new FoodProviderDAO();
            MenuDAO menuDAO = new MenuDAO();
            Scanner scan = new Scanner(System.in);
            int adminOperation;
            String dishOperation;
            String menuOperation;
            String menuName;
            String dishTitle;
            String dishDescription;
            Menu dishMenu;
            int dishMenuId;
            int dishMenuUpdateId;
            int menuDeleteId;
            int menuUpdateId;
            int dishDeleteId;
            int dishUpdateId;
            String newMenuName;
            String newTitle;
            String newDescription;
            Menu newMenu ;

            System.out.println("\nWelcome to admin panel. Please choose working panel:\n " +
                    "1. DISHES\n" +
                    "2. MENUS\n" +
                    "3. FOOD PROVIDERS\n" +
                    "4. RESERVATIONS\n");
            adminOperation = scan.nextInt();
            if (adminOperation == 1) {
                System.out.println("\nWhich operation you would like to execute?\n" +
                        "1. For adding a new dish.\n" +
                        "2. For deleting a dish.\n" +
                        "3. For editing a dish.\n" +
                        "4. For log out.\n" +
                        "Please enter the number of the option:\n");
                dishOperation = scan.next();
                if (dishOperation.equals("1")) {
                    System.out.println("Title of the dish?:");
                    scan.nextLine();
                    dishTitle = scan.nextLine();
                    System.out.println("Description of the dish?:");
                    dishDescription = scan.nextLine();
                    System.out.println("Category the book?:");
//                        __________________choose menu_______________
                    System.out.println("Chose a number of the menu id from the list below:\n");
                    System.out.println(menuDAO.searchAll());
                    dishMenuId = scan.nextInt();
                    dishMenu = menuDAO.searchById(dishMenuId);
                    System.out.println("\n New dish is added!\n");
//                        ________________________________________________
                    Dish newDish = new Dish(dishTitle, dishDescription, dishMenu);
                    dishDAO.insert(newDish);
                } else if (dishOperation.contains("2")) {
                    dishDAO.searchAll();
                    System.out.println("Enter the ID of the dish to delete:");
                    dishDeleteId = scan.nextInt();
                    dishDAO.deleteById(dishDeleteId);
                    System.out.println("\nThe dish is deleted\n");
                } else if (dishOperation.contains("3")) {
                    System.out.println(dishDAO.searchAll());
                    System.out.println("Enter id of the dish to edit:\n");
                    dishUpdateId = scan.nextInt();
                    System.out.println("Enter new title of the dish:\n");
                    scan.nextLine();
                    newTitle = scan.nextLine();
                    System.out.println("Enter new description of the dish:\n");
                    newDescription = scan.nextLine();
                    System.out.println("Enter new menu of the dish:\n");
                    //                        __________________choose category_______________
                    System.out.println("Chose a number of the menu id from the list below:\n");
                    System.out.println(menuDAO.searchAll());
                    dishMenuUpdateId = scan.nextInt();
                    newMenu = menuDAO.searchById(dishMenuUpdateId);
//                        ________________________________________________

                    Dish updatedDish = new Dish(dishUpdateId, newTitle, newDescription, newMenu);
                    dishDAO.update(updatedDish);
                    System.out.println("\nThe dish is updated!\n");
                }
            } else if (adminOperation == 2) {
                System.out.println("Which operation you would like to execute?\n" +
                        "1. For adding a new menu.\n" +
                        "2. For deleting a menu.\n" +
                        "3. For editing a menu.\n" +
                        "4. For log out." +
                        "Please enter the number of the option:");
                menuOperation = scan.next();
                if (menuOperation.equals("1")) {
                    System.out.println("Name of the menu?:\n");
                    scan.nextLine();
                    menuName = scan.nextLine();
                    Menu addMenu = new Menu(menuName);
                    menuDAO.insert(addMenu);
                    System.out.println("\nNew menu is added\n");
                } else if (menuOperation.equals("2")) {
                    menuDAO.searchAll();
                    System.out.println("Enter the ID of the menu to delete:");
                    menuDeleteId = scan.nextInt();
                    menuDAO.deleteById(menuDeleteId);
                    System.out.println("\nThe menu is deleted!\n");
                } else if (menuOperation.equals("3")) {
                    System.out.println(menuDAO.searchAll());
                    System.out.println("Enter id of the menu to edit:\n");
                    menuUpdateId = scan.nextInt();
                    System.out.println("Enter new name of the menu:\n");
                    scan.nextLine();
                    newMenuName = scan.nextLine();
                    Menu updatedMenu = new Menu(menuUpdateId, newMenuName);
                    menuDAO.update(updatedMenu);
                    System.out.println("\nThe menu is updated!\n");
                } else {
                    break;
                }
            }

        }
    }


    public static void userFunc(int userId) {
        while (true) {
            ReservationDAO reservationDAO = new ReservationDAO();
            FoodProviderDAO foodProviderDAO = new FoodProviderDAO();
            Scanner scan = new Scanner(System.in);
            int pickedFoodProviderId;
            Dish pickedFoodProvider;
            User currentUser;
            String chooseOperation;
            System.out.println("\nPlease select the operation by number:\n" +
                    "1. For searching for food providers.\n" +
                    "2. For log out.\n");
            chooseOperation = scan.next();
            if (chooseOperation.equals("1")) {
                System.out.println("Chose a food provider id from the list below:\n");
                System.out.println(foodProviderDAO.searchAll());
                pickedFoodProviderId = scan.nextInt();
                pickedFoodProvider = DishDAO.searchById(pickedFoodProviderId);
                currentUser = UserDAO.searchById(userId);

//                Reservation reservation = new Reservation(currentUser, pickedFoodProvider);
//                reservationDAO.insert(reservation);
//                System.out.println("Book reserved!");
            } else {
                break;
            }
        }
    }
}
