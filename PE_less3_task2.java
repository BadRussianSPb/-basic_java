/*Реализовать алгоритм пирамидальной сортировки (HeapSort) */

public class PE_less3_task2 {

    public static void sort(int arr[]) { // void - ничего не возвращает
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heap(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }
    }

    // ------------------------------------------------------------------

    static void heap(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // левый
        int r = 2 * i + 2; // правый

        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heap(arr, n, largest);
        }
    }

    // ------------------------------------------------------------------

    static void pic_builder(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        {
            int arr[] = { 24, 8, 1, 3, 2 };
            System.out.println("Исходный массив:");
            pic_builder(arr);
            sort(arr);
            System.out.println("Отсортированный массив: ");
            pic_builder(arr);
        }
    }
}
