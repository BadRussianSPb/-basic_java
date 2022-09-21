import java.util.ArrayList;

/* На вход некоторому исполнителю подаётся два числа (a, b). У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c
- команда 2 (к2): увеличить на d, к a прибавляется d
написать программу, которая выдаёт набор команд, позволяющий число a превратить в число b или сообщить, что это невозможно
Пример 1: а = 1, b = 7, c = 2, d = 1
ответ: к2, к2, к2, к2, к2, к2, k2 или к1, к1, к2, к2, к2 
Можно начать с более простого – просто подсчёта общего количесвтва вариантов 
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения. 
*Подумать над тем, как сделать минимальное количество команд
*Подумать над решением задачи 2 рекурсией
*/

public class PE_less1_task1_refact {

    static int transformation(int a, int b, int c, int d) {
        int[] result = new int[b + 1];
        if (a >= b | (d == 0 & c == 0)) {
            System.out.print("Решения нет");
            return 0;
        }
        result[a] = 1;
        for (int i = a + d; i <= b; i++) {
            if (i % c == 0) {
                result[i] = result[i - d] + result[i / c];
            } else {
                result[i] = result[i - d];
            }
        }
        System.out.printf("Всего путей: ");
        System.out.println(result[b]);
        System.out.println(print(result));

        if (result[b] != 0) {
            System.out.println();
            // System.out.println(routs(result, a, c, d));
        } else {
            System.out.println("Нет подходящих путей");
        }
        return result[b];
    }
    // ------------------------------------------------------------------

    static Object refact_transformation(int a, int b, int c, int d) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // int[] result = new int[b + 1];
        if (a >= b | (d == 0 & c == 0)) {
            System.out.print("Решения нет");
            return 0;
        }
        result.add(0, 0);
        result.add(a, 1);
        for (int i = a + d; i <= b; i++) {
            int spam = i - d;
            int spam_2 = i / c;
            if (i % c == 0) {
                // result[i] = result[i - d] + result[i / c];
                result.add(i, (spam + spam_2));
            } else {
                result.add(i, (spam));
            }
        }
        System.out.printf("Всего путей: ");
        System.out.println(result.get(b));
        System.out.println(refact_print(result));

        if (result.get(b) != 0) {
            System.out.println();
            // System.out.println(routs(result, a, c, d));
        } else {
            System.out.println("Нет подходящих путей");
        }
        return result.get(b);
    }

    // ------------------------------------------------------------------

    static String refact_print(ArrayList<Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < result.size(); n++) {
            sb.append(String.format("(%d) %d ", n, result.size()));
        }
        return sb.toString();
    }

    // ------------------------------------------------------------------

    static String print(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < result.length; n++) {
            sb.append(String.format("(%d) %d ", n, result.length));
        }
        return sb.toString();
    }

    // ------------------------------------------------------------------

    static String routs(int[] arr, int a, int c, int d) {
        int count = 0;
        StringBuilder route1 = new StringBuilder();
        StringBuilder route2 = new StringBuilder();
        System.out.println("Один из маршрутов (c>=d): ");
        for (int n = arr.length - 1; n > a;) {
            if (n % c == 0) {
                System.out.printf("k1 (%d/%d=%d)", n, c, n / c);
                route1.insert(0, "k1 ");
                n /= c;
            } else {
                route1.insert(0, "k2 ");
                System.out.printf("k2 (%d-%d=%d)", n, d, n - d);
                n -= d;
            }
            count++;
            System.out.println();
        }

        System.out.println("Один из маршрутов (c<d): ");
        for (int n = arr.length - 1; n > a;) {

            route2.insert(0, "k1 ");
            System.out.printf("k1 (%d-%d=%d)", n, d, n - d);
            n -= d;
            System.out.println();
            count--;
        }
        System.out.println("Лучший маршрут: ");
        if (count <= 0) {
            return route1.toString();
        } else {
            return route2.toString();
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        transformation(1, 7, 2, 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Затраты по времени при обычном массиве: " + (endTime - startTime) + "ms");
        System.out.println();
        startTime = System.currentTimeMillis();
        refact_transformation(1, 7, 2, 1);
        endTime = System.currentTimeMillis();
        System.out.println("Затраты по времени при использовании ArrayList : " + (endTime - startTime) + "ms");

    }
}
