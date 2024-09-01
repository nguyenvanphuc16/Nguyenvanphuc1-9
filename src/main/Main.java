package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> EnterData(ArrayList<Integer> numbers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so phan tu: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap phan tu thu " + (i + 1) + ": ");
            int number = scanner.nextInt();
            numbers.add(number);
        }
        return numbers;
    }

    public static void DisplayData(ArrayList<Integer> numbers) {
        System.out.println("Cac phan tu trong mang: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    // Method to find the second largest value in the list
    public static int findMax2(ArrayList<Integer> numbers) {
        if (numbers.size() < 2) {
            System.out.println("Khong du phan tu de tim gia tri lon thu 2.");
            return Integer.MIN_VALUE;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        boolean foundSecondMax = false;

        for (int number : numbers) {
            if (number > max1) {
                max2 = max1;
                max1 = number;
                foundSecondMax = true;
            } else if (number > max2 && number != max1) {
                max2 = number;
                foundSecondMax = true;
            }
        }

        if (!foundSecondMax) {
            System.out.println("Khong co phan tu lon thu 2.");
            return Integer.MIN_VALUE;
        } else {
            return max2;
        }
    }

    public static void deleteOddNumber(ArrayList<Integer> numbers) {
        numbers.removeIf(number -> number % 2 != 0);
        System.out.println("Da xoa cac phan tu le khoi mang.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Nhap mang so nguyen");
            System.out.println("2. Xuat ra mang");
            System.out.println("3. Tim gia tri phan tu lon thu 2 trong mang");
            System.out.println("4. Xoa cac phan tu le khoi mang");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    numbers = EnterData(numbers);
                    break;
                case 2:
                    DisplayData(numbers);
                    break;
                case 3:
                    int max2 = findMax2(numbers);
                    if (max2 != Integer.MIN_VALUE) {
                        System.out.println("Phan tu lon thu 2 trong mang la: " + max2);
                    }
                    break;
                case 4:
                    deleteOddNumber(numbers);
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    scanner.close();
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 5);
    }
}
