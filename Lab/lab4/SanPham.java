package lab4;
import java.util.Scanner;

public class SanPham {
    private String tenSP;
    private double donGia;
    private double giamGia;

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }
    
    public String getTenSP() {
        return this.tenSP;
    }
    public double getDonGia() {
        return this.donGia;
    }
    public double getGiamGia() {
        return this.giamGia;
    }
    
    public SanPham() {
        tenSP = "";
        donGia = 0;
        giamGia = 0;
    }
    public SanPham(String tenSP, double donGia, double giamGia) {
        this.tenSP = tenSP;        
        this.donGia = donGia;
        this.giamGia = giamGia;
    }
    public SanPham(String tenSP, double donGia) {
        this(tenSP, donGia, 0);
    }
    
    private double getThueNhapKhau() {
        return this.donGia * 0.1;
    }
    
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        this.tenSP = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        this.donGia = scanner.nextDouble();
        System.out.print("Nhập mức giảm giá: ");
        this.giamGia = scanner.nextDouble();
        System.out.println();
    }
    
    public void xuat() {
        System.out.printf("Tên sản phẩm: %s\n", this.tenSP);   
        System.out.printf("Đơn giá: %.2f\n", this.donGia);
        System.out.printf("Giảm giá: %.2f\n", this.giamGia);
        System.out.printf("Thuế nhập khẩu: %.2f\n", this.getThueNhapKhau());
        System.out.println();
    }
}
