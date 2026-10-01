package model;

/**
 * Product - Domain Model Layer
 * ข้อมูลสินค้าพื้นฐาน: รหัส, ชื่อ, ราคา, จำนวนคงเหลือ
 * ตาม Class Diagram: id, name, price, stock
 */
public class Product {

    private String id;
    private String name;
    private double price;
    private int stock;

    public Product() {
        // constructor เปล่า
    }

    public Product(String id, String name, double price, int stock) {
        //  กำหนดค่าเริ่มต้น
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public boolean isInStock() {
        //  ตรวจสอบ stock > 0
        return false;
    }

    public void addStock(int qty) {
        //  เพิ่มสต็อก
    }

    public void reduceStock(int qty) {
        //  ลดสต็อก (ใน diagram เขียน addStock ซ้ำ 2 บรรทัด — ร่างเป็น reduceStock ให้ถูกต้อง)
    }

    // --- getters / setters (ร่างไว้) ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
