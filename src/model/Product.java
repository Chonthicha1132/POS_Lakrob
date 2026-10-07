package model;

/**
 * Product - Domain Model Layer
 * ข้อมูลสินค้าพื้นฐาน: รหัส, ชื่อ, ราคา, จำนวนคงเหลือ
 * ตาม Class Diagram: id, name, price, stock
 */
public class Product {

    private String id;
    private String name;
    private String category;
    private double price;
    private int stock;

    public Product() {
        // constructor เปล่า
    }

    public Product(String id, String name, double price, int stock) {
        this(id, name, "", price, stock);
    }

    public Product(String id, String name, String category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category == null ? "" : category;
        this.price = price;
        this.stock = stock;
    }

    public boolean isInStock() {
        return stock > 0;
    }

    public boolean isLowStock() {
        return stock > 0 && stock <= 5;
    }

    public void addStock(int qty) {
        if (qty > 0) this.stock += qty;
    }

    public void reduceStock(int qty) {
        if (qty <= 0) return;
        this.stock -= qty;
        if (this.stock < 0) this.stock = 0;
    }

    // --- getters / setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category == null ? "" : category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = Math.max(0, stock); }

    public String getStatus() {
        if (stock <= 0) return "หมดสต็อก";
        if (stock <= 5) return "ใกล้หมด";
        return "พร้อมขาย";
    }
}
