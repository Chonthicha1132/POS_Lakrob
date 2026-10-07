package gui;
 
import javax.swing.*;
import java.awt.*;
 
/**
 * StyledButton - ปุ่มที่วาดสีเองทั้งหมด
 * แสดงสีเหมือนกันทุกเครื่อง/ทุก Look and Feel (เช่น macOS ที่มักไม่ยอมแสดงสีพื้นหลังของ JButton)
 * มีเอฟเฟกต์ตอนเอาเมาส์ชี้ (สว่างขึ้น) และตอนกด (เข้มลง) + เคอร์เซอร์เป็นรูปมือ
 */
public class StyledButton extends JButton {
 
    private Color baseColor;
    private final int arc;
 
    public StyledButton(String text, Color baseColor) {
        this(text, baseColor, 8);
    }
 
    public StyledButton(String text, Color baseColor, int arc) {
        super(text);
        this.baseColor = baseColor;
        this.arc = arc;
        setForeground(Color.WHITE);
        setFont(AppFont.thai(Font.BOLD, 13));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setRolloverEnabled(true);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
 
    /** เปลี่ยนสีหลักของปุ่ม (ใช้ตอนไฮไลต์ปุ่มที่ถูกเลือก) */
    public void setBaseColor(Color c) {
        this.baseColor = c;
        repaint();
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 
        Color c = baseColor;
        if (!isEnabled()) {
            c = Color.GRAY;
        } else if (getModel().isPressed()) {
            c = baseColor.darker();
        } else if (getModel().isRollover()) {
            c = brighten(baseColor);
        }
        g2.setColor(c);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
        g2.dispose();
 
        super.paintComponent(g);   // วาดข้อความทับ
    }
 
    private static Color brighten(Color c) {
        int r = Math.min(255, c.getRed() + 30);
        int gr = Math.min(255, c.getGreen() + 30);
        int b = Math.min(255, c.getBlue() + 30);
        return new Color(r, gr, b);
    }
}
