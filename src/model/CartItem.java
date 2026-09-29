package model;

/**
 * CartItem - Domain Model Layer
 * รายการสินค้าในตะกร้าหน้าร้าน มีความสัมพันธ์ 1:1 ไปหา Product
 * ตาม Class Diagram: product, quantity, unitPrice, subtotal
 */
public class CartItem {

    private Product product;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public CartItem() {
        // TODO: constructor เปล่า
    }

    public CartItem(Product product, int quantity) {
        // TODO: กำหนด product + quantity, snapshot unitPrice จาก product.getPrice()
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        // TODO: คำนวณ unitPrice * quantity
        return 0.0;
    }

    public void setQuantity(int qty) {
        // TODO: อัปเดตจำนวน + subtotal
    }

    // --- getters / setters (ร่างไว้) ---
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}
