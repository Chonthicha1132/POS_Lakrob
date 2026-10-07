package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import model.SaleOrder;
import service.FileStorageService;

/**
 * HistoryPanel - ร่างไว้ก่อน (แสดงประวัติจาก sales.csv)
 * เต็มๆ จะทำรอบถัดไป (กรองตามวัน + ดูรายละเอียด + รายงานยอด)
 */
public class HistoryPanel extends JPanel {

    private static final Color HEADER_BG = new Color(0x733D3D);
    private static final Color CONTENT_BG = new Color(0xE0D3D3);

    private List<SaleOrder> sales;
    private FileStorageService storage = new FileStorageService();
    private DefaultTableModel tableModel;

    public HistoryPanel() {
        setLayout(new BorderLayout());
        setBackground(CONTENT_BG);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(HEADER_BG);
        header.setPreferredSize(new Dimension(0, 75));
        header.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JLabel t = new JLabel("ประวัติการขายและรายงาน");
        t.setFont(AppFont.thai(Font.BOLD, 26));
        t.setForeground(Color.WHITE);
        JLabel s = new JLabel("ร่างไว้ก่อน - ดูประวัติย้อนหลังแบบง่าย");
        s.setFont(AppFont.thai(Font.PLAIN, 13));
        s.setForeground(Color.WHITE);
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setOpaque(false);
        left.add(t);
        left.add(s);
        header.add(left, BorderLayout.WEST);
        add(header, BorderLayout.NORTH);

        String[] cols = {"เลขที่บิล", "วันเวลา", "ยอดรวม", "สถานะ"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable table = new JTable(tableModel);
        table.setFont(AppFont.thai(Font.PLAIN, 14));
        table.setRowHeight(28);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createEmptyBorder(12, 16, 12, 16));
        scroll.getViewport().setBackground(Color.WHITE);
        add(scroll, BorderLayout.CENTER);

        loadHistory();
    }

    public void loadHistory() {
        sales = storage.loadSaleOrders();
        tableModel.setRowCount(0);
        for (SaleOrder o : sales) {
            tableModel.addRow(new Object[]{
                o.getId(),
                o.getOrderDate() == null ? "" : o.getOrderDate().toString().replace("T", " "),
                String.format("%.2f", o.getTotalAmount()),
                o.getStatus()
            });
        }
        if (sales.isEmpty()) {
            tableModel.addRow(new Object[]{"-", "ยังไม่มีข้อมูลการขาย", "-", "-"});
        }
    }

    public SaleOrder viewDetail(String orderId) {
        if (sales != null) {
            for (SaleOrder o : sales) if (o.getId().equals(orderId)) return o;
        }
        return SaleOrder.loadById(orderId);
    }

    public List<SaleOrder> getSales() { return sales; }
}
