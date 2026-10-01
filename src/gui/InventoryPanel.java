package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import service.FileStorageService;

/**
 * InventoryPanel - Presentation Layer (JPanel)
 * หน้าจัดการสต็อก: เพิ่ม/แก้ไข/ลบสินค้า ใช้ (Use) FileStorageService
 * ตาม Class Diagram: products + load/add/update/delete
 */
public class InventoryPanel extends JPanel {

    private List<Product> products;
    private FileStorageService storage;

    public InventoryPanel() {
        //  สร้าง UI ตารางสินค้า + ฟอร์มเพิ่ม/แก้ไข
        this.products = new ArrayList<>();
        this.storage = new FileStorageService();
    }

    public void loadProducts() {
        // products = storage.loadProducts(); refresh ตาราง
    }

    public void addProduct(Product product) {
        //  products.add + storage.saveProduct(product)
    }

    public void updateProduct(Product product) {
        //  อัปเดตใน products + storage.saveProduct(product)
    }

    public void deleteProduct(String productId) {
        //  ลบออกจาก products + storage.delete(productId)
    }

    // --- getters (ร่างไว้) ---
    public List<Product> getProducts() { return products; }
}
