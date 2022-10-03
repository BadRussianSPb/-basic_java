import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PE_less5_task1 {

    static ArrayList<Integer> getSell(Integer x, Integer y) {
        ArrayList<Integer> sell = new ArrayList<Integer>(2);
        sell.add(x);
        sell.add(y);
        return sell;
    }

    static void picBuilder(LinkedHashMap<ArrayList<Integer>, Integer> matrix) {
        for (ArrayList<Integer> el : matrix.keySet()) {
            if (el.get(1) == 0) {
                System.out.println();
            }
            System.out.printf(String.format("%3d ", matrix.get(el)));
        }
        System.out.println();
        System.out.println("------------------------------------------------------------");
    }

    static ArrayList<Integer> getPoint(ArrayList<Integer> point, Integer n) {
        ArrayList<Integer> spam = new ArrayList<Integer>(2);
        if (n == 1) {
            spam.add(0, point.get(0) - 1);
            spam.add(1, point.get(1));
        }
        if (n == 2) {
            spam.add(0, point.get(0));
            spam.add(1, point.get(1) + 1);
        }

        if (n == 3) {
            spam.add(0, point.get(0) + 1);
            spam.add(1, point.get(1));
        }

        if (n == 4) {
            spam.add(0, point.get(0));
            spam.add(1, point.get(1) - 1);
        }
        return spam;
    }

    public static void main(String[] args) {
        LinkedHashMap<ArrayList<Integer>, Integer> matrix = new LinkedHashMap<>();
        ArrayDeque<ArrayList<Integer>> queue = new ArrayDeque<>();

        // строим матрицу
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 13; j++) {
                ArrayList<Integer> z = getSell(i, j); // i => x, j => y
                if (j == 0 | i == 0 | i == 13 | j == 12) {
                    matrix.put(z, -1);
                } else {
                    matrix.put(z, 0);
                }
            }
        }
        picBuilder(matrix);

        // задаем точки и стены

        ArrayList<Integer> enterPoint = getSell(8, 3); // точка входа
        // matrix.put(enterPoint, -2);

        ArrayList<Integer> exitPoint = getSell(1, 11); // точка выхода
        // matrix.put(exitPoint, -3);

        // стены по X
        for (int y = 4; y < 8; y++) {
            matrix.put(getSell(4, y), -1);
        }
        for (int y = 8; y < 11; y++) {
            matrix.put(getSell(7, y), -1);
        }
        for (int y = 2; y < 9; y++) {
            matrix.put(getSell(9, y), -1);
        }
        for (int y = 3; y < 8; y++) {
            matrix.put(getSell(11, y), -1);
        }
        // стены по Y
        for (int x = 2; x < 8; x++) {
            matrix.put(getSell(x, 2), -1);
        }
        for (int x = 4; x < 8; x++) {
            matrix.put(getSell(x, 4), -1);
        }
        for (int x = 4; x < 9; x++) {
            matrix.put(getSell(x, 8), -1);
        }
        matrix.put(getSell(3, 9), -1);

        // главная часть волнового алгоритма

        queue.add(enterPoint);
        while (queue.size() != 0) {

            for (int n = 1; n < 5; n++) {
                ArrayList<Integer> newStep = getPoint(queue.peek(), n);
                Integer nextStep = matrix.get(newStep);
                if (nextStep == 0) {
                    queue.add(newStep);
                    matrix.put(newStep, matrix.get(queue.peek()) + 1);
                    // System.out.println("ДА");
                } else {
                    // System.out.println("Нет");
                }
            }
            queue.poll();
        }
        picBuilder(matrix);
        System.out.println(String.format("Выход в точке %d:%d через %d ходов", exitPoint.get(0), exitPoint.get(1),
                matrix.get(exitPoint)));
    }
}
