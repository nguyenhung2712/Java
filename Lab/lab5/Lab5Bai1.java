package lab5;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab5Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> real = new ArrayList<>();
        System.out.println("Nhập mảng các số thực");
        while (true) {
            Double num = scanner.nextDouble();
            real.add(num);
            
            scanner.nextLine();
            System.out.println("Nhập thêm (Y/N)?");
            if (scanner.nextLine().toLowerCase().equals("n")) {
                break;
            }
        }
        real.forEach(x -> {
            System.out.println(x);
        });
    }
}
