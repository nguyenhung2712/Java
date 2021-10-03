package lab3;

public class MultiTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 10; j++) {
                System.out.printf("%d x %d = %d\t", i, j, i * j);
            }
            System.out.println();
        }
    }
}
