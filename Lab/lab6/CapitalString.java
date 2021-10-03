package lab6;
import java.util.Arrays;
import java.util.Scanner;

public class CapitalString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập họ và tên: ");
        
        String nameInput = input.nextLine();
        /*String[] namePart = nameInput.split(" ");
        for (int i = 0; i < namePart.length; i++) {
            if (i == 0 || i == namePart.length - 1) {
                System.out.println(namePart[i].toUpperCase());
            } else {
                System.out.println(namePart[i]);
            }
        }*/
        int firstIndex = 0, lastIndex = 0, length = nameInput.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(nameInput.charAt(i))) {
                firstIndex = i;
                break;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (Character.isWhitespace(nameInput.charAt(i))) {
                lastIndex = i;
                break;
            }
        }
        String firstName = nameInput.substring(0, firstIndex);
        String middleName = nameInput.substring(firstIndex + 1, lastIndex);
        String lastName = nameInput.substring(lastIndex + 1, length);
        System.out.println(firstName.toUpperCase() + " " + middleName + " " + lastName.toUpperCase());
    }
}
