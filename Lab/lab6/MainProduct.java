package lab6;
import java.util.ArrayList;
import java.util.Scanner;

class SanPham {
    public static ArrayList<SanPham> productArr = new ArrayList<>();
    private String tenSP;
    private Float donGia;
    private String hang;

    public void setHang(String hang) {
        this.hang = hang;
    }
    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }
    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    public String getTenSP() {
        return this.tenSP;
    }
    public double getDonGia() {
        return this.donGia;
    }
    public String getHang() {
        return hang;
    }
    
    public SanPham() {
        tenSP = "";
        donGia = (float)0;
        hang = "";
    }
    public SanPham(String tenSP, Float donGia, String hang) {
        this.tenSP = tenSP;        
        this.donGia = donGia;
        this.hang = hang;
    }
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        Float productPrice = scanner.nextFloat();
        System.out.print("Nhập hãng: ");
        scanner.nextLine();
        String firm = scanner.nextLine();
        
        SanPham sp = new SanPham();
        sp.setTenSP(productName);
        sp.setDonGia(productPrice);
        sp.setHang(firm);
        productArr.add(sp);
        
        System.out.println();
    }
    public void xuat() {
        if (productArr.isEmpty()) {
            System.out.println("Không thể thực hiện chức năng này do mảng hiện tại rỗng.");
        } else {
            System.out.println("Tên\t\tĐơn giá\t\tHãng"); 
            for (int i = 0; i < productArr.size(); i++) {
                System.out.printf("%s", productArr.get(i).tenSP);
                System.out.printf("\t\t%.2f\n", productArr.get(i).donGia);
                System.out.printf("\t\t%s", productArr.get(i).hang);
            }
        }
    }
    public void filter(String firmFind) {
        if (productArr.isEmpty()) {
            System.out.println("Không thể thực hiện chức năng này do mảng hiện tại rỗng.");
        } else {
            System.out.println("Tên\t\tĐơn giá\t\tHãng"); 
            for (int i = 0; i < productArr.size(); i++) {
                if (productArr.get(i).hang.equals("Nokia")) {
                    System.out.printf("%s", productArr.get(i).tenSP);
                    System.out.printf("\t\t%.2f\n", productArr.get(i).donGia);
                    System.out.printf("\t\t%s", productArr.get(i).hang);
                }
            }
        }
    }
}

public class MainProduct {
    public static void main(String[] args) {
        SanPham sp = new SanPham();
        for (int i = 0; i < 2; i++) {
            sp.nhap();
        }
        sp.xuat();
    }
}
