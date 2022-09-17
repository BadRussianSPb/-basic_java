// Найти наибольшую общую подпоследовательность из 2-х заданных.

public class PE_less2_task_on_less {

    static StringBuilder compare(int[] b_arr, int[] c_arr) {

        StringBuilder result = new StringBuilder();
        int n = 0;
        for (int i = 0; i < b_arr.length; i++) {
            for (int j = n; j < c_arr.length; j++) {
                // System.out.printf("i=(%d) %d, j=(%d) %d ", i, b_arr[i], j, c_arr[j]);
                if (b_arr[i] == c_arr[j]) {
                    result.append(b_arr[i]);
                    result.append(" ");
                    if (i < b_arr.length - 1) { // без костылей никак...
                        i++;
                    }
                    n = j + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] base_arr = new int[] { 4, 0, 0, 1, 2, 3, 7 };
        int[] compare_arr = new int[] { 4, 2, 1, 2, 3 };
        System.out.printf("Самая длинная подпоследовательность (первая): ");
        if (base_arr.length > compare_arr.length) {
            System.out.println(compare(compare_arr, base_arr));
        } else {
            System.out.println(compare(base_arr, compare_arr));
        }
    }
}
