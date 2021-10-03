package lab3;
import java.util.Arrays;
import java.util.Scanner;

public class HandleArr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
}
