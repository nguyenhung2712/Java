package lab3;
import java.util.Arrays;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        handleStudentArr(scanner);
    }
    // Bài 1
    public static boolean isPrime(Scanner scanner) {
        int num = scanner.nextInt();
        for (int i = 2; Math.sqrt(num) >= i; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    // Bài 2
    public static void multiTable() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 10; j++) {
                System.out.printf("%d x %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
    //Bài 3
    public static void handleArray(Scanner scanner) {
        int length;
        do {
            System.out.print("Nhập số phần tử của mảng: ");
            length = scanner.nextInt();
            if (length < 0) {
                System.out.println("Vui lòng nhập lại.");
            }
        } while (length < 0);
        int arr[] = new int[length];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < length; i++) {
            System.out.printf("arr[%d] = ", i + 1);
            arr[i] = scanner.nextInt();
        }
        // 1. Sort Array
        Arrays.sort(arr, 0, length);
        System.out.print("Các phần tử của mảng sau khi sắp xếp: ");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + "\t");
        }
        // 2. Min value System.out.print(arr[0]);
        int minVal = arr[0];
        for (int i = 1; i < length; i++) {
            minVal = Math.min(minVal, arr[i]);
        }
        System.out.printf("Giá trị nhỏ nhất trong mảng: %d", minVal);
        // 3. AVG of value which divisible by 3
        int sum = 0, count = 0;
        for (int i = 1; i < length; i++) {
            if (arr[i] % 3 == 0) {
                ++count;
                sum += arr[i];
            }
        }
        System.out.printf("TBC các giá trị chia hết cho 3: %.2f", (float)sum/count);
        
        System.out.println();
    }
    // Bài 4
    public static String handleAbility(float grade) {
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
    public static void handleStudentArr(Scanner scanner) {
        int length;
        do {
            System.out.print("Nhập số lượng sinh viên: ");
            length = scanner.nextInt();
            if (length < 0) {
                System.out.println("Vui lòng nhập lại.");
            }
        } while (length < 0);
        float grade[] = new float[length];
        String[] name = new String[length];
        System.out.println("Nhập thông tin của các sinh viên: ");
        for (int i = 0; i < length; i++) {
            System.out.printf("Sinh viên thứ %d\n", i + 1);
            System.out.print("Họ và tên: ");
            scanner.nextLine();
            name[i] = scanner.nextLine();
            System.out.print("Điểm số: ");
            grade[i] = (float)scanner.nextDouble();
        }
        
        for (int i = 0; i < length; i++) {
            System.out.print(name[i] + "\t" + grade[i] + "\t" + handleAbility(grade[i]));
            System.out.println();
        }
        
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (grade[j] > grade[j + 1]) {
                    float temp1 = grade[j];
                    grade[j] = grade[j + 1];
                    grade[j + 1] = temp1;
                    
                    String temp2 = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = temp2;
                }
            }
        }
        System.out.println("Sau khi sắp xếp: ");
        for (int i = 0; i < length; i++) {
            System.out.print(name[i] + "\t" + grade[i] + "\t" + handleAbility(grade[i]));
            System.out.println();
        }
    }
}
