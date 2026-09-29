package Gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JPanel {

    public static final int DESIGN_WIDTH = 1200, DESIGN_HEIGHT = 800;

    private static final Color HEADER_BG = new Color(0x733D3D),
     CONTENT_BG = new Color(0xE0D3D3),
            CART_BG = new Color(0xB09E9E), 
            SIDEBAR_BG = new Color(0x8F3E3E), 
            SIDEBAR_BTN = new Color(0x733030),
            SIDEBAR_ACTIVE = new Color(0xA84A4A), 
            CAT_BTN_BG = new Color(0x5E2B2B), 
            CAT_ACTIVE = new Color(0x8B1E1E),
            BLUE = new Color(0x2D8CEB), 
            PAY_BG = new Color(0xA04040);

    private static final String MEAT = "เนื้อ,หมู,ไก่,ทะเล";
    private static final String[][] SAMPLE = {
        {"กุ้งขาว", MEAT, "M001"}, 
        {"แฮมพันเห็ดเข็มทอง", MEAT, "M002"}, 
        {"หมูสามชั้น", MEAT, "M003"},
        {"อกไก่", MEAT, "M004"}, 
        {"เนื้อวัว A5", MEAT, "M005"},
         {"ปูอัดจัมโบ้", "ลูกชิ้น", "M006"},
        {"ไส้กรอกชีส", "ลูกชิ้น", "M007"}, 
        {"เต้าหู้ชีส", "ลูกชิ้น", "M008"},
         {"ไส้กรอกแดง", "ลูกชิ้น", "M009"},
        {"เห็ดเข็มทอง", "ผักต่างๆ", "M010"}, 
        {"ฟักทอง", "ผักต่างๆ", "M011"}, 
        {"มันฝรั่ง", "ผักต่างๆ", "M012"},
    };

    public MainFrame() {
        Dimension size = new Dimension(DESIGN_WIDTH, DESIGN_HEIGHT);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setLayout(new BorderLayout());
        setBackground(CONTENT_BG);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(CONTENT_BG);
        main.add(createHeader(), BorderLayout.NORTH);
        main.add(createMenuArea(), BorderLayout.CENTER);

        add(createSidebar(), BorderLayout.WEST);
        add(main, BorderLayout.CENTER);
        add(createCartPanel(), BorderLayout.EAST);
    }

    // ---------- Helpers ----------
    private static Font font(int style, int size) {
        return new Font("Tahoma", style, size);
    }

    private static JLabel label(String text, int style, int size, Color color) {
        JLabel l = new JLabel(text);
        l.setFont(font(style, size));
        l.setForeground(color);
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        return l;
    }

    private static JPanel boxPanel() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setOpaque(false);
        return p;
    }

    private static JPanel transparent(LayoutManager lm) {
        JPanel p = new JPanel(lm);
        p.setOpaque(false);
        return p;
    }

    private static StyledButton button(String text, Color bg, int radius, int style, int size) {
        StyledButton b = new StyledButton(text, bg, radius);
        b.setFont(font(style, size));
        return b;
    }

    private static StyledButton sidebarButton(String text) {
        StyledButton b = button(text, SIDEBAR_BTN, 5, Font.BOLD, 12);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setPreferredSize(new Dimension(150, 42));
        b.setMaximumSize(new Dimension(150, 42));
        return b;
    }

    // ---------- Sidebar ----------
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(new BorderLayout());
        sidebar.setPreferredSize(new Dimension(175, DESIGN_HEIGHT));
        sidebar.setBackground(SIDEBAR_BG);
        sidebar.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JPanel top = boxPanel();
        top.add(label("POS", Font.BOLD, 28, Color.WHITE));
        top.add(Box.createVerticalStrut(3));
        top.add(label("ระบบจัดการร้าน", Font.BOLD, 13, Color.WHITE));
        top.add(Box.createVerticalStrut(20));

        String[] items = {"เมนูหน้าร้าน", "จัดการสินค้าและสต็อก", "ประวัติการขายและรายงาน"};
        for (int i = 0; i < items.length; i++) {
            StyledButton b = sidebarButton(items[i]);
            if (i == 0) b.setBaseColor(SIDEBAR_ACTIVE);
            top.add(b);
            top.add(Box.createVerticalStrut(8));
        }

        JPanel bottom = boxPanel();
        bottom.add(label("<html><b>ผู้ใช้งาน : user</b><br>สิทธิ์ : พนักงานขาย<br>22/09/2026 22:06</html>",
                Font.PLAIN, 11, Color.WHITE));
        bottom.add(Box.createVerticalStrut(12));
        StyledButton logout = sidebarButton("ออกจากระบบ");
        logout.setBaseColor(new Color(0xB46A6A));
        bottom.add(logout);

        sidebar.add(top, BorderLayout.NORTH);
        sidebar.add(bottom, BorderLayout.SOUTH);
        return sidebar;
    }

    // ---------- Header ----------
    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(HEADER_BG);
        header.setPreferredSize(new Dimension(0, 75));
        header.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel title = new JLabel("เมนูทั้งหมดในร้าน");
        title.setFont(font(Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JTextField txtSearch = new JTextField(16);
        txtSearch.setFont(font(Font.PLAIN, 16));

        JPanel search = transparent(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        search.add(label("ค้นหาเมนู:", Font.BOLD, 18, Color.WHITE));
        search.add(txtSearch);

        header.add(title, BorderLayout.WEST);
        header.add(search, BorderLayout.EAST);
        return header;
    }

    // ---------- Menu Area ----------
    private JPanel createMenuArea() {
        JPanel area = new JPanel(new BorderLayout());
        area.setBackground(CONTENT_BG);
        area.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JPanel cats = transparent(new FlowLayout(FlowLayout.LEFT, 12, 8));
        List<StyledButton> catButtons = new ArrayList<>();
        for (String c : new String[]{"ทั้งหมด", MEAT, "ลูกชิ้น", "ผักต่างๆ"}) {
            StyledButton b = new StyledButton(c, catButtons.isEmpty() ? CAT_ACTIVE : CAT_BTN_BG);
            b.setPreferredSize(new Dimension(140, 38));
            b.addActionListener(e -> catButtons.forEach(x -> x.setBaseColor(x == b ? CAT_ACTIVE : CAT_BTN_BG)));
            catButtons.add(b);
            cats.add(b);
        }

        JPanel grid = transparent(new GridLayout(0, 3, 15, 15));
        for (String[] p : SAMPLE) grid.add(createProductCard(p[0], p[1], p[2], 10, 20));

        JPanel wrap = transparent(new BorderLayout());
        wrap.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        wrap.add(grid, BorderLayout.NORTH);

        JScrollPane scroll = new JScrollPane(wrap);
        scroll.setBorder(null);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        area.add(cats, BorderLayout.NORTH);
        area.add(scroll, BorderLayout.CENTER);
        return area;
    }

    // ---------- Product Card ----------
    private JPanel createProductCard(String name, String category, String code, int price, int stock) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 8, 10));

        StyledButton btnAdd = button("+ เพิ่มลงในตะกร้า", BLUE, 6, Font.PLAIN, 12);
        btnAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAdd.setMaximumSize(new Dimension(170, 26));

        card.add(label(name, Font.BOLD, 18, Color.BLACK));
        card.add(label(category + " - รหัส " + code, Font.PLAIN, 11, Color.DARK_GRAY));
        card.add(Box.createVerticalStrut(4));
        card.add(label("฿" + price, Font.BOLD, 20, Color.BLACK));
        card.add(Box.createVerticalStrut(4));
        card.add(btnAdd);
        card.add(Box.createVerticalStrut(2));
        card.add(label("คงเหลือ " + stock + " ชิ้น", Font.PLAIN, 10, Color.RED));
        return card;
    }

    // ---------- Cart ----------
    private JPanel createCartPanel() {
        JPanel cart = new JPanel(new BorderLayout(0, 10));
        cart.setBackground(CART_BG);
        cart.setPreferredSize(new Dimension(300, 0));
        cart.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        // Header
        JPanel left = transparent(new FlowLayout(FlowLayout.LEFT, 8, 0));
        left.add(label("รายการสั่งซื้อ", Font.BOLD, 15, Color.WHITE));
        left.add(label("0 รายการ", Font.PLAIN, 11, Color.WHITE));

        JButton btnClear = new JButton("ล้างตะกร้า");
        btnClear.setFont(font(Font.BOLD, 11));
        btnClear.setFocusPainted(false);

        JPanel head = transparent(new BorderLayout());
        head.add(left, BorderLayout.WEST);
        head.add(btnClear, BorderLayout.EAST);

        // List
        JPanel list = transparent(new GridBagLayout());
        list.add(label("<html><div style='text-align:center'>ยังไม่มีรายการสั่งซื้อ<br>"
                + "คลิกเลือกเมนูรายการด้านซ้าย<br>เพื่อดำเนินการสั่งซื้อ</div></html>",
                Font.PLAIN, 11, Color.WHITE));

        // Summary
        JPanel sum = new JPanel(new GridLayout(3, 2, 5, 8));
        sum.setBackground(new Color(0xF0EAEA));
        sum.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField txtDiscount = new JTextField("0");
        txtDiscount.setHorizontalAlignment(JTextField.RIGHT);

        sum.add(summaryLabel("รวมเป็นเงิน :", false));
        sum.add(summaryLabel("฿0.00", true));
        sum.add(summaryLabel("ส่วนลด :", false));
        sum.add(txtDiscount);
        sum.add(summaryLabel("ยอดสุทธิ :", false));
        sum.add(summaryLabel("฿0.00", true));

        StyledButton btnPay = button("ชำระเงิน", PAY_BG, 10, Font.BOLD, 22);
        btnPay.setPreferredSize(new Dimension(0, 55));

        JPanel bottom = transparent(new BorderLayout(0, 10));
        bottom.add(sum, BorderLayout.CENTER);
        bottom.add(btnPay, BorderLayout.SOUTH);

        cart.add(head, BorderLayout.NORTH);
        cart.add(list, BorderLayout.CENTER);
        cart.add(bottom, BorderLayout.SOUTH);
        return cart;
    }

    private JLabel summaryLabel(String text, boolean right) {
        JLabel l = new JLabel(text);
        l.setFont(font(Font.BOLD, 13));
        if (right) l.setHorizontalAlignment(SwingConstants.RIGHT);
        return l;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("POS System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel background = new JPanel(new GridBagLayout());
            background.setBackground(new Color(0xD6D0D0));
            background.add(new MainFrame());

            frame.setContentPane(background);
            frame.setSize(DESIGN_WIDTH, DESIGN_HEIGHT);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}