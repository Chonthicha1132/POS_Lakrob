package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * SaleOrder - Domain Model Layer
 * หัวบิล / ใบเสร็จรับเงิน ประกอบด้วย SaleOrderItem หลายแถว (Composition)
 * ถูกสร้างโดย User (create by)
 * ตาม Class Diagram: id, orderDate, totalAmount, status
 */
public class SaleOrder {

    private String id;
    private LocalDateTime orderDate;
    private double totalAmount;
    private String status;
    private User createdBy;
    private List<SaleOrderItem> items;

    public SaleOrder() {
        this.items = new ArrayList<>();
    }

    public SaleOrder(String id, User createdBy) {
        this.id = id;
        this.createdBy = createdBy;
        this.orderDate = LocalDateTime.now();
        this.status = "paid";
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int qty) {
        if (product == null || qty <= 0) return;
        String itemId = id + "-" + (items.size() + 1);
        items.add(new SaleOrderItem(itemId, product, qty, product.getPrice()));
        calculateTotal();
    }

    public void removeItem(String productId) {
        items.removeIf(it -> it.getProduct() != null && it.getProduct().getId().equals(productId));
        calculateTotal();
    }

    public double calculateTotal() {
        double sum = 0;
        for (SaleOrderItem it : items) sum += it.getSubtotal();
        this.totalAmount = sum;
        return totalAmount;
    }

    public List<SaleOrderItem> getItems() {
        return items;
    }

    public void save() {
        try {
            service.FileStorageService fs = new service.FileStorageService();
            fs.saveSaleOrder(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SaleOrder loadById(String orderId) {
        try {
            service.FileStorageService fs = new service.FileStorageService();
            for (SaleOrder o : fs.loadSaleOrders()) {
                if (o.getId().equals(orderId)) return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // --- getters / setters (ร่างไว้) ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }
}
