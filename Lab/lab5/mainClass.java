/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }
    // Bài 1
    public static void arrayListD(Scanner scanner) {
        ArrayList<Double> real = new ArrayList<>();
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
    // Bài 2
    public static void menu(Scanner scanner) {
        ArrayList<String> nameArr = new ArrayList<>();
        nhap(nameArr, scanner);
        xuat(nameArr);
    }
    private static void nhap(ArrayList<String> nameArr, Scanner scanner) {
        while (true) {
            String name = scanner.nextLine();
            nameArr.add(name);
            
            System.out.println("Nhập thêm (Y/N)?");
            if (scanner.nextLine().toLowerCase().equals("n")) {
                break;
            }
        }
    }
    private static void xuat(ArrayList<String> nameArr) {
        nameArr.forEach(name -> {
            System.out.println(name);
        });
    }
    private static void ngaunhien(ArrayList<String> nameArr) {
        Collections.shuffle(nameArr);
    }
    private static void sapxep(ArrayList<String> nameArr) {
        Collections.sort(nameArr);
        Collections.reverse(nameArr);
    }
    private static void xoa(ArrayList<String> nameArr, int index) {
        nameArr.remove(index);
    }
    // Bài 3
    
}
