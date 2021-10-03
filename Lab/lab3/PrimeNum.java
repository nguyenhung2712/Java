package lab3;
import java.util.Scanner;

public class PrimeNum {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Nhập số cần kiểm tra: ");
            int num = scanner.nextInt();
            if (isPrime(num)) {
                System.out.println("Đây là số nguyên tố");
            } else {
                System.out.println("Đây không là số nguyên tố");
            }
        } catch (Exception ex) {
            System.out.println("Dữ liệu không hợp lệ.");
        }
    }
    public static boolean isPrime(int num) {
        for (int i = 2; Math.sqrt(num) >= i; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
