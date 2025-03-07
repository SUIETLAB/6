
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserManagementSystem {
    private static List<User> users = new ArrayList<>();
    private static int idCounter = 1; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("Welcome to the User Management System!");
        System.out.println("=========================================");

        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Insert User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    insertUser(scanner);
                    break;
                case "2":
                    viewUsers();
                    break;
                case "3":
                    updateUser(scanner);
                    break;
                case "4":
                    deleteUser(scanner);
                    break;
                case "5":
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("5"));

        scanner.close();
    }

  
    private static void insertUser(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        User user = new User(idCounter++, name, email);
        users.add(user);
        System.out.println("User created: " + user.name + " (" + user.email + ")");
        
    }

    private static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
            return;
        }
        System.out.println("Current Users:");
        for (User user : users) {
            System.out.printf("ID: %d | Name: %s | Email: %s%n", user.id, user.name, user.email);
        }
        
    }

    
    private static void updateUser(Scanner scanner) {
        System.out.print("Enter user ID to update: ");
        int userId = Integer.parseInt(scanner.nextLine());
        for (User user : users) {
            if (user.id == userId) {
                System.out.print("Enter new name: ");
                user.name = scanner.nextLine();
                System.out.print("Enter new email: ");
                user.email = scanner.nextLine();
                System.out.println("User updated: " + user.name + " (" + user.email + ")");
                
                return;
            }
        }
        System.out.println("User not found for update.");
    }
    private static void deleteUser(Scanner scanner) {
        System.out.print("Enter user ID to delete: ");
        int userId = Integer.parseInt(scanner.nextLine());
        for (User user : users) {
            if (user.id == userId) {
                users.remove(user);
                System.out.println("User deleted with ID: " + userId);
              
                return;
            }
        }
        System.out.println("User not found for deletion.");
    }
}

class User {
    int id;
    String name;
    String email;

    User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
