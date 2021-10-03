package lab7;

class ChuNhat {
    protected float dai;   
    protected float rong;
    
    public ChuNhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }
    protected double getChuVi() {
        return (this.dai + this.rong) * 2;
    }
    protected double getDienTich() {
        return this.dai * this.rong;
    }
    
    public void xuat() {
        System.out.printf("Chiều rộng: %.2f, chiều dài: %.2f, chu vi: %.2f, diện tích: %.2f\n", rong, dai, this.getChuVi(), this.getDienTich());
    }
}

class Vuong extends ChuNhat {
    public Vuong(float canh) {
        super(canh, canh);
    }
    @Override
    public void xuat() {
        System.out.printf("Cạnh: %.2f, chu vi: %.2f, diện tích: %.2f\n", rong, getChuVi(), getDienTich());
    }
}

public class Lab7Bai1 {
    public static void main(String[] args) {
        Vuong cn = new Vuong(3);
        cn.xuat();
    }
    
}
