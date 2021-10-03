package lab6;

import java.util.ArrayList;
import java.util.Scanner;

class SinhVien {
    public static ArrayList<SinhVien> studentArr = new ArrayList<>();
    public String hoTen;
    private String email;
    private String sdt;
    private String cmnd;

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }
    public String getHoTen() {
        return hoTen;
    }
    public String getEmail() {
        return email;
    }
    public String getSdt() {
        return sdt;
    }
    public String getCmnd() {
        return cmnd;
    }
    
    public SinhVien() {
        hoTen = "";
        email = "";
        sdt = "";
        cmnd = "";
    }
    public SinhVien(String hoTen, String email, String sdt, String cmnd) {
        this.hoTen = hoTen;        
        this.email = email;
        this.sdt = sdt;
        this.cmnd = cmnd;
    }
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập họ tên: ");
            String studentName = scanner.nextLine();
            System.out.print("Nhập mail: ");
            String studentMail = scanner.nextLine();
            System.out.print("Nhập số điện thoại: ");
            String studentPhone = scanner.nextLine();
            System.out.print("Nhập chứng minh nhân dân: ");
            String studentIdentity = scanner.nextLine();
            if (
                !studentMail.matches("\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"") ||
                !studentPhone.matches("^(0[0|3|5|7])([0-9]{8})$") ||
                !studentIdentity.matches("[0-9]{9}")
            ) {
                throw new IllegalArgumentException("Định dạng nhập vào không hợp lệ");
            } else {
                SinhVien sv = new SinhVien();
                sv.setHoTen(studentName);
                sv.setEmail(studentMail);
                sv.setSdt(studentPhone);
                sv.setCmnd(studentIdentity);
                studentArr.add(sv);
            }
        } catch(Exception ex) {
            System.out.println(ex);
        }
        System.out.println();
    }
    public void xuat() {
        if (studentArr.isEmpty()) {
            System.out.println("Không thể thực hiện chức năng này do mảng hiện tại rỗng.");
        } else {
            for (int i = 0; i < studentArr.size(); i++) {
                System.out.printf("Họ tên: %s\n", studentArr.get(i).hoTen);
                System.out.printf("Mail liên lạc: %s\n", studentArr.get(i).email);
                System.out.printf("Số điện thoại: %s\n", studentArr.get(i).sdt);
                System.out.printf("Số chứng minh nhân dân: %s\n\n", studentArr.get(i).cmnd);
            }
        }
    }
}

public class MainStudent {
    public static void main(String[] args) {
        
    }
}
