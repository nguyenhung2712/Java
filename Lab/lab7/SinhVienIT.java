package lab7;

public class SinhVienIT extends SinhVienPoly {
    public double diemJava;    
    public double diemCss;
    public double diemHtml;

    public SinhVienIT(String hoTen, double diemJava, double diemCss, double diemHtml) {
        super(hoTen, "CNTT");
        this.diemJava = diemJava;        
        this.diemCss = diemCss;
        this.diemHtml = diemHtml;
    }
    @Override
    public double getDiem() {
        return (double)(2*this.diemJava + this.diemHtml + this.diemCss) / 4;
    }
}
