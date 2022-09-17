import java.util.Scanner;

// Задана натуральная степень k. Сформировать случайным образом список коэффициентов
// (значения от 0 до 100) многочлена многочлен степени k. ​
// *Пример: k=2 => 2*x² + 4*x + 5 = 0 или x² + 5 = 0 или 10*x² = 0​

public class lesson_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Задайте натуральную степень для многочлена: ");
        String degree = iScanner.nextLine(); // пользовательский ввод из консоли
        iScanner.close();
        int k = Integer.valueOf(degree); // преобразовал строку в число
        int[] odds = new int[k + 1]; // создал массив длинной k + 1
        // System.out.println(odds.length);
        // ниже создаю массив длинной k из случайных чисел
        for (int i = 0; i < k + 1; i++) {
            odds[i] = (int) (Math.random() * 100);
            System.out.printf("%d-й коэфициент: ", i + 1);
            System.out.println(odds[i]);
        }
    }

}
