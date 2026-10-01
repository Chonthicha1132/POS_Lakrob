package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import model.CartItem;
import model.Product;

/**
 * PosPanel - Presentation Layer (JPanel)
 * หน้าขอขาย: เลือกสินค้า คำนวณเงิน จัดการตะกร้า ประกอบด้วย CartItem หลายตัว
 * ตาม Class Diagram: cart, totalAmount + add/remove/update/calculate/clear/checkout
 */
public class PosPanel extends JPanel {

    private List<CartItem> cart;
    private double totalAmount;

    public PosPanel() {
        //  สร้าง UI (ตาม MainFrame เดิม: header, menu grid, cart panel)
        this.cart = new ArrayList<>();
    }

    public void addProduct(Product product, int qty) {
        //  Product -> CartItem (ถ้ามีแล้วให้บวก qty) แล้ว refresh + calculateTotal
    }

    public void removeItem(String productId) {
        //  ลบ CartItem ตาม productId
    }

    public void updateQuantity(String productId, int qty) {
        // อัปเดตจำนวนชิ้นของ CartItem
    }

    public double calculateTotal() {
        // รวม getSubtotal() ทุก cart -> totalAmount
        return 0.0;
    }

    public void clearCart() {
        //  ล้างตะกร้า + reset totalAmount
    }

    public void checkout() {
        //  CartItem -> SaleOrder.addItem() -> save() -> FileStorageService.saveSaleOrder()
        //       -> ตัดสต็อก Product -> clearCart()
    }

    // --- getters (ร่างไว้) ---
    public List<CartItem> getCart() { return cart; }
    public double getTotalAmount() { return totalAmount; }
}
