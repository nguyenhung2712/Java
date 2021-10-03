package lab1;
import java.util.Scanner;

public class Lab1Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập các hệ số: ");
            float a = scanner.nextFloat();
            float b = scanner.nextFloat();
            float c = scanner.nextFloat();
            double delta = Math.pow(b, 2) - 4*a*c;
            
            if (delta < 0) {
                throw new ArithmeticException ("Không thể tính căn delta do delta âm!");
            } else {
                System.out.printf("Delta: %.2f\nsqrt(Delta): %.2f", delta, Math.sqrt(delta));
                System.out.println();
            }
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("Dữ liệu nhập không hợp lệ!");
        }
    }
}
