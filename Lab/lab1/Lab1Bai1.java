package lab1;
import java.util.Scanner;

public class Lab1Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Họ và Tên: ");
            String name = scanner.nextLine();       
            System.out.print("Điểm TB: ");
            float grade = scanner.nextFloat();
            if (grade < 0 || grade > 10) {
                throw new ArithmeticException ("Điểm nhập không hợp lệ (Thang điểm 10)!");
            } else {
                System.out.printf("%s %.2f điểm", name, grade);
                System.out.println();
            }
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("Dữ liệu nhập không hợp lệ");
        }
    }
}
