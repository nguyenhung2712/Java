package lab7;

abstract class SinhVienPoly implements Comparable<SinhVienPoly> {
    protected String hoTen;
    protected String nganh;
    
    public SinhVienPoly(String hoTen, String nganh) {
        this.hoTen = hoTen;
        this.nganh = nganh;
    }
    
    abstract protected double getDiem();
    protected String getHocLuc() {
        double grade = this.getDiem();
        if (grade < 5) {
            return "Yếu";
        } else if (grade >= 5 && grade < 6.5) {
            return "Trung bình";
        } else if (grade >= 6.5 && grade < 7.5) {
            return "Khá";
        } else if (grade >= 7.5 && grade < 9) {
            return "Giỏi";
        } else {
            return "Xuất sắc";  
        }
    }
    public void xuat() {
        System.out.printf("Họ tên: %s\n", this.hoTen);
        System.out.printf("Ngành: %s\n", this.nganh);
        System.out.printf("Điểm: %.2f\n", this.getDiem());
        System.out.printf("Học lực: %s\n\n", this.getHocLuc());
    }
    
    @Override
    public int compareTo(SinhVienPoly sv) {
        if (this.getDiem() < sv.getDiem()) {
            return 1;
        } else if (this.getDiem() > sv.getDiem()) {
            return -1;
        } else {
            return 0;
        }
    }
}
