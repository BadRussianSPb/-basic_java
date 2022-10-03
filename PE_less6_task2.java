
/*
 * 2. Реализовать структуру данных "Очередь" на основе массива
 * 2.1 Нужно сделать операцию "Добавить в очередь"
 * 2.2 Нужно сделать операцию "Извлечь из очереди"
 */

public class PE_less6_task2 {

    public static void main(String[] args) {
        pe_queue spam = new pe_queue();
        spam.print();
        spam.add(100);
        spam.add(50);
        spam.add(110);
        spam.add(110);
        spam.print();
        System.out.println(String.format("Элементов: %d\nРазмер очереди: %d", spam.getsize(), spam.getBigSize()));
        spam.add(110);
        spam.add(110);
        spam.add(110);
        spam.add(110);
        spam.add(110);
        spam.add(110);
        spam.add(110);
        spam.add(110);
        spam.add(110);
        spam.print();
        System.out.println(String.format("Элементов: %d\nРазмер очереди: %d", spam.getsize(), spam.getBigSize()));
        System.out.println(String.format("Удаляем первый из очереди элемент: %d", spam.out()));

        spam.print();
        System.out.println(String.format("Элементов: %d\nРазмер очереди: %d", spam.getsize(), spam.getBigSize()));
    }
}

class pe_queue {
    int size = 10;
    public int[] arr = new int[size + 1];
    public int count = 0;

    // добавление в конец очереди и увеличение очереди при заполнении
    void add(Integer value) {
        if (count == size - 1) {
            size *= 10;
            int[] spam_arr = arr;
            arr = new int[size];
            for (int i = 0; i < count; i++) {
                arr[i] = spam_arr[i];
            }
        }
        arr[count++] = value;
    }

    // удаление первого элемента из очереди
    Integer out() {
        int spam = arr[0];
        for (int i = 0; i < count; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
        return spam;
    }

    void print() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d, ", arr[i]);
        }
        System.out.println("]");
    }

    // количество элементов
    Integer getsize() {
        Integer result = count;
        return result;
    }

    // размер очереди
    Integer getBigSize() {
        Integer result = size;
        return result;
    }

}