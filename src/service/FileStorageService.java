package service;

import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.SaleOrder;
import model.User;

/**
 * FileStorageService - Service & Persistence Layer
 * ลูกของ Service ทำหน้าที่อ่าน-เขียนลงไฟล์ (Flat files / JSON / CSV)
 * ถูก Use โดย InventoryPanel, HistoryPanel (และ PosPanel ผ่าน SaleOrder.save())
 * ตาม Class Diagram: basePath + save/load Product, SaleOrder, User
 */
public class FileStorageService extends Service {

    private String basePath;

    public FileStorageService() {
        //  basePath default เช่น "data/"
        this.basePath = "data/";
    }

    public FileStorageService(String basePath) {
        //  กำหนด path โฟลเดอร์เก็บไฟล์
        this.basePath = basePath;
    }

    // --- Product ---
    public void saveProduct(Product product) {
        //  เขียน product ลงไฟล์
    }

    public List<Product> loadProducts() {
        //  อ่านไฟล์ -> List<Product>
        return new ArrayList<>();
    }

    // --- SaleOrder ---
    public void saveSaleOrder(SaleOrder order) {
        //  เขียน order ลงไฟล์
    }

    public List<SaleOrder> loadSaleOrders() {
        //  อ่านไฟล์ -> List<SaleOrder>
        return new ArrayList<>();
    }

    // --- User ---
    public void saveUser(User user) {
        //  เขียน user ลงไฟล์
    }

    public User loadUser() {
        //  อ่านไฟล์ -> User (ตาม diagram ไม่มี param)
        return null;
    }

    // --- override จาก Service (abstract) ---
    @Override
    public void save(Object data) {
        //  route ตามชนิด data -> saveProduct / saveSaleOrder / saveUser
    }

    @Override
    public Object load() {
        //  default load (เช่น loadProducts)
        return null;
    }

    @Override
    public void delete(String id) {
        //  ลบข้อมูลตาม id
    }

    // --- getter/setter ---
    public String getBasePath() { return basePath; }
    public void setBasePath(String basePath) { this.basePath = basePath; }
}
