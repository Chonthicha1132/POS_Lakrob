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
        //  กำหนด id, createdBy, orderDate = now, status เริ่มต้น
        this.id = id;
        this.createdBy = createdBy;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int qty) {
        //  แปลง Product -> SaleOrderItem แล้ว add ลง items
    }

    public void removeItem(String productId) {
        //  ลบ SaleOrderItem ตาม productId
    }

    public double calculateTotal() {
        //  รวม subtotal ทุก item -> totalAmount
        return 0.0;
    }

    public List<SaleOrderItem> getItems() {
        //  คืนค่า items
        return items;
    }

    public void save() {
        //  เรียก FileStorageService.saveSaleOrder(this)
    }

    public static SaleOrder loadById(String orderId) {
        //  เรียก FileStorageService โหลดตาม id
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
