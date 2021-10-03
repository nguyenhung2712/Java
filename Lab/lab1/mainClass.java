package lab1;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tiền: ");
        try {
            float money = input.nextFloat();
            if (money < 0) {
                throw new ArithmeticException ("Tiền nhập không hợp lệ.");
            } else {
                if (money < 9000000) {
                System.out.print("Không đóng thuế");
                } else if (money >= 9000000 && money < 15000000) {
                    System.out.printf("Thuế %.2f", money*0.1);
                } else if (money >= 15000000 && money < 30000000) {
                    System.out.printf("Thuế %.2f", money*0.15);
                } else {
                    System.out.printf("Thuế %.2f", money*0.2);
                }
                System.out.println();
            }
        } catch (Exception ex) {
            System.out.println("Tiền nhập không hợp lệ.");
        }
    }
}   
