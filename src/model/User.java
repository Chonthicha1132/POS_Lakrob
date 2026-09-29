package model;

/**
 * User - Domain Model Layer
 * เก็บข้อมูลผู้ใช้งาน สำหรับตรวจสอบสิทธิ์ login และระบุผู้ทำรายการ (create by SaleOrder)
 * ตาม Class Diagram: id, username, password, role
 */
public class User {

    private String id;
    private String username;
    private String password;
    private String role;

    public User() {
        // TODO: constructor เปล่า (สำหรับ FileStorageService โหลดข้อมูล)
    }

    public User(String id, String username, String password, String role) {
        // TODO: กำหนดค่าเริ่มต้น
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean checkPermission() {
        // TODO: ตรวจสอบสิทธิ์ตาม role
        return false;
    }

    public String getRole() {
        // TODO: คืนค่า role
        return role;
    }

    // --- getters / setters (ร่างไว้) ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public void setRole(String role) { this.role = role; }
}
