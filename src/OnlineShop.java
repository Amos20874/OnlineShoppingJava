import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class implementing all 5 interfaces for the Online Shopping System.
 */
public class OnlineShop implements LoginSystem, ProductCatalog, CartSystem, CheckoutSystem, AdminPanel {

    // Store users (username, password)
    private ArrayList<String[]> users = new ArrayList<>();
    // Store products
    private ArrayList<String[]> products = new ArrayList<>();
    // Store cart items
    private ArrayList<String[]> cart = new ArrayList<>();
    // Logged-in user
    private String loggedInUser = null;

    public static void main(String[] args) {
        OnlineShop shop = new OnlineShop();
        shop.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== Online Shopping System ====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Products");
            System.out.println("4. Add to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Remove Product (Admin)");
            System.out.println("8. Logout");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String user = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String pass = scanner.nextLine();
                    register(user, pass);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    String uname = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String pword = scanner.nextLine();
                    if (login(uname, pword)) {
                        System.out.println("Login successful.");
                    } else {
                        System.out.println("Login failed.");
                    }
                    break;
                case 3:
                    viewProducts();
                    break;
                case 4:
                    System.out.print("Enter product ID: ");
                    int pid = scanner.nextInt();
                    addToCart(pid);
                    break;
                case 5:
                    viewCart();
                    break;
                case 6:
                    checkout();
                    break;
                case 7:
                    System.out.print("Enter product ID to remove: ");
                    int rid = scanner.nextInt();
                    removeProduct(rid);
                    break;
                case 8:
                    logout();
                    loggedInUser = null;
                    break;
                case 9:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    // LOGIN SYSTEM
    public void register(String username, String password) {
        users.add(new String[]{username, password});
        System.out.println("User registered successfully.");
    }

    public boolean login(String username, String password) {
        for (String[] user : users) {
            if (user[0].equals(username) && user[1].equals(password)) {
                loggedInUser = username;
                return true;
            }
        }
        return false;
    }

    // PRODUCT CATALOG
    public void addProduct(String name, double price) {
        products.add(new String[]{name, String.valueOf(price)});
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            emptyCatalogMessage();
            return;
        }
        int id = 0;
        for (String[] product : products) {
            System.out.println(id + ": " + product[0] + " - $" + product[1]);
            id++;
        }
    }

    // CART SYSTEM
    public void addToCart(int productId) {
        if (productId >= 0 && productId < products.size()) {
            cart.add(products.get(productId));
            System.out.println("Product added to cart.");
        } else {
            System.out.println("Invalid product ID.");
        }
    }

    public void removeFromCart(int productId) {
        if (productId >= 0 && productId < cart.size()) {
            cart.remove(productId);
            System.out.println("Product removed from cart.");
        } else {
            System.out.println("Invalid product ID.");
        }
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            emptyCartMessage();
            return;
        }
        for (String[] item : cart) {
            System.out.println(item[0] + " - $" + item[1]);
        }
    }

    // CHECKOUT
    public void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add products first.");
            return;
        }
        System.out.println("Order Summary:");
        double total = 0;
        for (String[] item : cart) {
            System.out.println(item[0] + " - $" + item[1]);
            total += Double.parseDouble(item[1]);
        }
        System.out.println("Total: $" + total);
        thankCustomer();
        cart.clear();
    }

    // ADMIN PANEL
    public void removeProduct(int productId) {
        if (productId >= 0 && productId < products.size()) {
            products.remove(productId);
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Invalid product ID.");
 }
}
}
