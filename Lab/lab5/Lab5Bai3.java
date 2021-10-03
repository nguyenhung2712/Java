package lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SanPham {
    public static ArrayList<SanPham> productArr = new ArrayList<>();
    private String tenSP;
    private Float donGia;

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
    
    public SanPham() {
        tenSP = "";
        donGia = (float)0;
    }
    public SanPham(String tenSP, Float donGia) {
        this.tenSP = tenSP;        
        this.donGia = donGia;
    }
    
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập đơn giá: ");
        Float productPrice = scanner.nextFloat();
        
        SanPham sp = new SanPham();
        sp.setTenSP(productName);
        sp.setDonGia(productPrice);
        productArr.add(sp);
        
        System.out.println();
    }
    public void xuat() {
        if (productArr.isEmpty()) {
            System.out.println("Không thể thực hiện chức năng này do mảng hiện tại rỗng.");
        } else {
            System.out.println("Tên\t\tĐơn giá"); 
            for (int i = 0; i < productArr.size(); i++) {
                System.out.printf("%s", productArr.get(i).tenSP);
                System.out.printf("\t\t%.2f\n", productArr.get(i).donGia);
            }
        }
    }
    public void sapxep() {
        Comparator<SanPham> comp = new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return sp2.donGia.compareTo(sp1.donGia);
            }
        };
        //Comparator<SanPham> comp = (SanPham sp1, SanPham sp2) -> sp2.donGia.compareTo(sp1.donGia);
        Collections.sort(productArr, comp);
        xuat();
    }
    public void xoa(String nameFind) {
        if (productArr.isEmpty()) {
            System.out.println("Không thể thực hiện chức năng này do mảng hiện tại rỗng.");
        } else {
            boolean isRemovedP = productArr.removeIf(sp -> sp.tenSP.equals(nameFind));
            /*for (SanPham sp: productArr) {
                if (sp.tenSP.equals(nameFind)) {
                    checkFound = true;
                    productArr.remove(sp.tenSP);
                    productArr.remove(sp.donGia);
                    break;
                }
            }*/
            if (!isRemovedP) {
                System.out.println("\nKhông tìm thấy phần tử cần xóa\n");
            } else {
                System.out.printf("\nMảng sau khi xóa phần tử %s\n", nameFind);
                xuat();
            }
        }
    }
    public void giaTB() {
        if (productArr.isEmpty()) {
            System.out.println("Không thể thực hiện chức năng này do mảng hiện tại rỗng.");
        } else {
            float avgPrice = 0;
            int count = 0;
            for (SanPham sp: productArr) {
                avgPrice += sp.donGia;
                ++count;
            }
            System.out.printf("Giá trung bình của các sản phẩm: %.2f\n", (float)avgPrice/count);
        }
    }
}

public class Lab5Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);        
        SanPham sp = new SanPham();
        while (true) {
            sp.nhap();
            System.out.println("Tiếp tục nhập tiếp (Y/N)?");
            if (scanner.nextLine().toLowerCase().equals("n")) {
                break;
            }
        }
        System.out.println("+----------------------------------+");
        System.out.println("1. Sắp xếp giảm dần theo giá");
        System.out.println("2. Xuất giá trung bình của các sản phẩm");
        System.out.println("3. Tìm và xóa sản phẩm được nhập tên từ bàn phím");
        System.out.println("4. Kết thúc");
        System.out.println("+----------------------------------+");
        System.out.print("Chọn chức năng: ");
        try {
            int choose;
            do {
                choose = scanner.nextInt();
                if (choose < 1 || choose > 4) {
                    System.out.println("Vui lòng nhập lại.");
                }
            } while(choose < 1 || choose > 4);
            switch (choose) {
                case 1 -> sp.sapxep();
                case 2 -> sp.giaTB();
                case 3 -> {
                    System.out.print("Nhập tên sản phẩm muốn xóa: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    sp.xoa(name);
                }
                case 4 -> System.exit(0);
                default -> System.exit(0);
            }
        } catch (Exception ex) {
            System.out.print("Dữ liệu không hợp lệ.");
        }
    }
}
