package Onlineshop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Cartitem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addProduct(Productitem product, int quantity) {
        for (Cartitem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new Cartitem(product, quantity));
    }

    public void removeProduct(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public List<Cartitem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Cartitem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ShoppingCart [items=" + items + "]";
    }
}
