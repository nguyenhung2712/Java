package product_arraylist;

public class SanPham {
	private String MaSP;
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	private String TenSP;
	private float DonGia;
	public SanPham() {
		MaSP = "";
		TenSP = "";
		DonGia = 0;
	}
	public SanPham(String maSP, String tenSP, float donGia) {
		MaSP = maSP;
		TenSP = tenSP;
		DonGia = donGia;
	}
}
