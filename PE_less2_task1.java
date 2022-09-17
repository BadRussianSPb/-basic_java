// Написать программу вычисления n-ого треугольного числа.

import java.util.Scanner;

public class PE_less2_task1 {

    static int recursive_search(int triangular, int n) {
        if (n == 0) {
            return triangular;
        } else {
            return recursive_search(triangular += n, --n);
        }
    }

    static int formula_search(int triangular, int n) {
        triangular = (n * (n + 1)) / 2;
        return triangular;
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Задайте порядкок треугольного числа: ");
        String text = iScanner.nextLine();
        iScanner.close();
        int n = Integer.valueOf(text);
        System.out.printf("Рекурсвиный поиск %d треугольного числа по формуле. Ответ: %d", n, recursive_search(0, n));
        System.out.println("");
        System.out.printf("Поиск %d треугольного числа по формуле. Ответ: %d", n, formula_search(0, n));
        System.out.println("");
    }
}
