package Onlineshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineShoppingSystem {
    private List<Productitem> products;
    private ShoppingCart cart;

    public OnlineShoppingSystem() {
        products = new ArrayList<>();
        cart = new ShoppingCart();
    }

    public void addProduct(Productitem product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Productitem product : products) {
            System.out.println(product);
        }
    }

    public void displayCart() {
        for (Cartitem item : cart.getItems()) {
            System.out.println(item);
        }
        System.out.println("Total Price: $" + cart.getTotalPrice());
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        cart = new ShoppingCart(); // Clear the cart after placing the order
    }

    public static void main(String[] args) {
        OnlineShoppingSystem system = new OnlineShoppingSystem();
        system.addProduct(new Productitem(1, "Laptop", 1200.00));
        system.addProduct(new Productitem(2, "Smartphone", 800.00));
        system.addProduct(new Productitem(3, "Headphones", 150.00));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayProducts();
                    break;
                case 2:
                    System.out.print("Enter product ID to add to cart: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    Productitem product = system.products.stream()
                            .filter(p -> p.getId() == productId)
                            .findFirst()
                            .orElse(null);
                    if (product != null) {
                        system.cart.addProduct(product, quantity);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    system.displayCart();
                    break;
                case 4:
                    System.out.print("Enter product ID to remove from cart: ");
                    productId = scanner.nextInt();
                    system.cart.removeProduct(productId);
                    break;
                case 5:
                    system.placeOrder();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}