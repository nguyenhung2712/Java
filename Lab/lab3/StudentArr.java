package lab3;
import java.util.Scanner;

public class StudentArr {
    public static void main(String[] args) {
        handleStudentArr();
    }
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
    public static void handleStudentArr() {
        Scanner scanner = new Scanner(System.in);
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
