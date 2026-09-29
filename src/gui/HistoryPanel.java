package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import model.SaleOrder;
import service.FileStorageService;

/**
 * HistoryPanel - Presentation Layer (JPanel)
 * หน้าประวัติขายย้อนหลัง + รายงาน ใช้ (Use) FileStorageService
 * ตาม Class Diagram: sales + loadHistory(), viewDetail()
 */
public class HistoryPanel extends JPanel {

    private List<SaleOrder> sales;
    private FileStorageService storage;

    public HistoryPanel() {
        // TODO: สร้าง UI ตารางประวัติ + ปุ่มดูรายละเอียด
        this.sales = new ArrayList<>();
        this.storage = new FileStorageService();
    }

    public void loadHistory() {
        // TODO: sales = storage.loadSaleOrders(); refresh ตาราง
    }

    public SaleOrder viewDetail(String orderId) {
        // TODO: หาใน sales หรือ SaleOrder.loadById(orderId) แล้วโชว์ dialog
        return null;
    }

    // --- getters (ร่างไว้) ---
    public List<SaleOrder> getSales() { return sales; }
}
