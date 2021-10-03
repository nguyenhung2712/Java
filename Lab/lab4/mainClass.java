package lab4;

public class MainClass {
    public static void main(String[] args) {
        
        
        SanPham sp1 = new SanPham("Nước giải khát", 20000, 0.5);        
        SanPham sp2 = new SanPham("Đồ chơi", 15000);
        sp1.xuat();   
        sp2.xuat();
    }
}
