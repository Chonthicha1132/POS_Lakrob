package gui;

import javax.swing.*;
import model.User;

/**
 * LoginFrame - Presentation Layer (JFrame)
 * หน้าต่างเริ่มต้นสำหรับยืนยันตัวตน มีความสัมพันธ์ opens -> MainFrame
 * ตาม Class Diagram: usernameField, passwordField, login(), authenticate()
 */
public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        // TODO: ตั้ง title, size, layout, สร้าง usernameField + passwordField + ปุ่ม login
        this.usernameField = new JTextField(16);
        this.passwordField = new JPasswordField(16);
    }

    public boolean login() {
        // TODO: เรียก authenticate() ถ้าผ่าน -> opens MainFrame + dispose ตัวเอง
        return false;
    }

    public boolean authenticate() {
        // TODO: ตรวจสอบ username/password (ผ่าน FileStorageService.loadUser หรือ mock)
        return false;
    }

    /** opens -> MainFrame: เปิดหน้าหลักหลัง login สำเร็จ */
    private void openMainFrame(User user) {
        // TODO: new MainFrame(user).setVisible(true); this.dispose();
    }
}
