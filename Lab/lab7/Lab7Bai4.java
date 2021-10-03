package lab7;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab7Bai4 {
    static ArrayList<SinhVienIT> dsCNTT = new ArrayList<>();
    static ArrayList<SinhVienBiz> dsQTKD = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }
    static void nhapDsCNTT() {
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Họ tên: ");
                String hoTen = input.nextLine();
                System.out.print("Điểm java: ");
                double diemJava = input.nextFloat();
                System.out.print("Điểm HTML: ");
                double diemHtml = input.nextFloat();
                System.out.print("Điểm CSS: ");
                double diemCss = input.nextFloat();
                input.nextLine();
                dsCNTT.add(new SinhVienIT(hoTen, diemJava, diemHtml, diemCss));
                System.out.println("Tiếp tục nhập (Y/N)?");
                if (input.nextLine().equals("N")) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Dữ liệu nhập không hợp lệ.");
        }
    }
    static void nhapDsQTKD() {
        Scanner input = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Họ tên: ");
                String hoTen = input.nextLine();
                System.out.print("Điểm Marketing: ");
                double diemMarketing = input.nextFloat();
                System.out.print("Điểm Sales: ");
                double diemSales = input.nextFloat();
                input.nextLine();
                dsQTKD.add(new SinhVienBiz(hoTen, diemMarketing, diemSales));
                System.out.println("Tiếp tục nhập (Y/N)?");
                if (input.nextLine().equals("N")) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Dữ liệu nhập không hợp lệ.");
        }
    }
    static void xuat() {
        for (SinhVienIT sv: dsCNTT) {
            sv.xuat();
        }
        for (SinhVienBiz sv: dsQTKD) {
            sv.xuat();
        }
    }
    static void svGioi() {
        for (SinhVienIT sv: dsCNTT) {
            if (sv.getHocLuc().equals("Giỏi")) {
                sv.xuat();
            }
        }
        for (SinhVienBiz sv: dsQTKD) {
            if (sv.getHocLuc().equals("Giỏi")) {
                sv.xuat();
            }
        }
    }
    static void sapXep() {
        ArrayList<SinhVienPoly> sv = new ArrayList<>();
        sv.addAll(dsCNTT);
        sv.addAll(dsQTKD);
        Collections.sort(sv, SinhVienPoly::compareTo);
        
        for (SinhVienPoly s: sv) {
            s.xuat();
        }
    }
    static void menu() {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            System.out.println("+------------------------------------------------+");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Xuất thông tin danh sách sinh viên");
            System.out.println("3. Xuất danh sách sinh viên có học lực giỏi");
            System.out.println("4. Xuất danh sách sinh viên theo điểm");
            System.out.println("5. Kết thúc");
            System.out.println("+------------------------------------------------+");
            
            int choose = input.nextInt();
            boolean exitCheck = false;
            switch (choose) {
                case 1 -> {
                    System.out.println("Nhập thông tin sinh viên: 1. QTKD       2. CNTT");
                    int speChosen = input.nextInt();
                    switch (speChosen) {
                        case 1 -> {
                            System.out.println("Nhập thông tin sinh viên QTKD");
                            nhapDsQTKD();
                            System.out.println();
                        }
                        case 2 -> {
                            System.out.println("Nhập thông tin sinh viên CNTT");
                            nhapDsCNTT();
                            System.out.println();
                        }
                        default -> System.out.println("Ngành nhập không hợp lệ");
                    }
                }
                case 2 -> {
                    System.out.println("Xuất thông tin sinh viên");
                    xuat();
                }
                case 3 -> {
                    System.out.println("Xuất thông tin sinh viên học lực giỏi");
                    svGioi();
                }
                case 4 -> {
                    System.out.println("Danh sách viên đã sắp xếp theo điểm");
                    sapXep();
                }
                case 5 -> {
                    System.out.println("Dừng chương tình");
                    System.exit(0);
                    exitCheck = true;
                }
                default -> {
                    System.out.println("Dừng chương tình");
                    System.exit(0);
                    exitCheck = true;
                }
            }
            if (exitCheck) {
                break;
            }
        }
    }
}
