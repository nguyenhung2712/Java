package lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lab5Bai2 {
    static ArrayList<String> nameArr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }
    public static void menu(Scanner scanner) {
        
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("1. Nhập danh sách họ tên");
            System.out.println("2. Xuất danh sách vừa nhập");
            System.out.println("3. Xuất danh sách ngẫu nhiên");
            System.out.println("4. Xuất danh sách sau khi sắp xếp giảm dần");
            System.out.println("5. Tìm và xóa phần tử nhập từ bàn phím");
            System.out.println("6. Kết thúc");
            System.out.println("+----------------------------------+");
            System.out.print("Chọn chức năng: ");
            int choose;
            boolean exitCheck = false;
            do {
                choose = scanner.nextInt();
                if (choose < 1 || choose > 6) {
                    System.out.println("Vui lòng nhập lại.");
                }
            } while(choose < 1 || choose > 6);
            switch (choose) {
                case 1 -> nhap();
                case 2 -> xuat();
                case 3 -> ngaunhien();
                case 4 -> sapxep();
                case 5 -> {
                    System.out.print("Nhập phần tử muốn xóa: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    xoa(name);
                }
                case 6 -> {
                    System.out.println("Ngừng chương trình");
                    exitCheck = true;
                    System.exit(0);
                }
                default -> {
                    System.out.println("Ngừng chương trình");
                    exitCheck = true;
                    System.exit(0);
                }
            }
            if (exitCheck) {
                break;
            }
        }
    }
    private static void nhap() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String name = scanner.nextLine();
                nameArr.add(name);
            } catch (Exception ex) {
                System.out.print("Dữ liệu không hợp lệ.");
            }
            System.out.println("Nhập thêm (Y/N)?");
            if (scanner.nextLine().toLowerCase().equals("n")) {
                break;
            }
        }
    }
    private static void xuat() {
        nameArr.forEach(name -> {
            System.out.println(name);
        });
    }
    private static void ngaunhien() {
        Collections.shuffle(nameArr);
        System.out.println("\nMảng sau khi sắp xếp ngẫu nhiên");
        xuat();
    }
    private static void sapxep() {
        Collections.sort(nameArr);
        Collections.reverse(nameArr);
        System.out.println("\nMảng sau khi sắp xếp giảm dần");
        xuat();
    }
    private static void xoa(String nameFind) {
        boolean checkFound = false;
        for (String name: nameArr) {
            if (name.equals(nameFind)) {
                nameArr.remove(name);
                checkFound = true;
                break;
            }
        }
        if (!checkFound) {
            System.out.println("\nKhông tìm thấy phần tử cần xóa\n");
        } else {
            System.out.printf("\nMảng sau khi xóa phần tử %s\n", nameFind);
            xuat();
        }
    }
}
