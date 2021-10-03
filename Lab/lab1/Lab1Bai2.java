
package lab1;
import java.util.Scanner;

public class Lab1Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Chiều dài: ");        
            float d = scanner.nextFloat();
            System.out.print("Chiều rộng: ");
            float r = scanner.nextFloat();
            if (d < 0 || r < 0) {
                throw new ArithmeticException ("Kích thước nhập không hợp lệ!");
            } else {
                System.out.printf("Chu vi: %.2f\nDiện tích: %.2f\nCạnh nhỏ nhất: %.2f", (d+r)*2, d*r, Math.min(d, r));
                System.out.println();
            }
        } catch (ArithmeticException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println("Dữ liệu nhập không hợp lệ");
        }
        
    }
}
