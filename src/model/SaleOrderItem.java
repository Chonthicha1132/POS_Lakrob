package model;

/**
 * SaleOrderItem - Domain Model Layer
 * แถวรายการย่อยของสินค้าแต่ละชิ้นในบิล (ลูกของ SaleOrder แบบ Composition)
 * ตาม Class Diagram: id, product, quantity, unitPrice, subtotal
 */
public class SaleOrderItem {

    private String id;
    private Product product;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public SaleOrderItem() {
        // TODO: constructor เปล่า
    }

    public SaleOrderItem(String id, Product product, int quantity, double unitPrice) {
        // TODO: กำหนดค่าเริ่มต้น
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        // TODO: คำนวณ unitPrice * quantity
        return 0.0;
    }

    // --- getters / setters (ร่างไว้) ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}
