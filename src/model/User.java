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
        //  constructor เปล่า (สำหรับ FileStorageService โหลดข้อมูล)
    }

    public User(String id, String username, String password, String role) {
        //  กำหนดค่าเริ่มต้น
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean checkPermission() {
        return role != null && !role.isBlank();
    }

    public boolean isAdmin() {
        if (role == null) return false;
        String r = role.trim().toLowerCase();
        return r.equals("admin") || r.contains("admin") || r.contains("จัดการ") || r.contains("เจ้าของ");
    }

    public boolean checkPassword(String password) {
        if (password == null) return false;
        return password.equals(this.password);
    }

    public String getRole() {
        return role;
    }

    public String getDisplayRole() {
        if (isAdmin()) return "ผู้จัดการร้าน";
        if (role == null || role.isBlank()) return "พนักงานขาย";
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
