
package lab7;

public class SinhVienBiz extends SinhVienPoly {
    public double diemMarketing;    
    public double diemSales;

    public SinhVienBiz(String hoTen, double diemMarketing, double diemSales) {
        super(hoTen, "QTKD");
        this.diemMarketing = diemMarketing;        
        this.diemSales = diemSales;
    }
    @Override
    public double getDiem() {
        return (double)(2*this.diemMarketing + this.diemSales) / 3;
    }
}
