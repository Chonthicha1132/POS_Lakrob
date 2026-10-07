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
        //  constructor เปล่า
    }

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = Math.max(1, quantity);
        this.unitPrice = product != null ? product.getPrice() : 0;
        this.subtotal = this.unitPrice * this.quantity;
    }

    public double getSubtotal() {
        this.subtotal = unitPrice * quantity;
        return subtotal;
    }

    public void setQuantity(int qty) {
        if (qty < 0) qty = 0;
        this.quantity = qty;
        this.subtotal = this.unitPrice * this.quantity;
    }

    public void increase(int delta) {
        setQuantity(this.quantity + delta);
    }

    // --- getters / setters (ร่างไว้) ---
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}
