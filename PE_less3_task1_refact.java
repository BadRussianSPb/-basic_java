
/* Написать программу, показывающую последовательность действий для игры “Ханойская башня” */
import java.util.Stack;

public class PE_less3_task1_refact {

    static Stack<Integer> tower_builder(int a, Boolean c) {
        Stack<Integer> tower_arr = new Stack<Integer>();
        // Integer[] tower_arr = new Integer[a];
        if (c) {
            tower_arr.push(0);
            for (int i = a; i > 0; i--) {
                tower_arr.push(i);
            }
        } else {
            tower_arr.push(0);

        }
        System.out.println(tower_arr + " Стэк сформирован ");
        return tower_arr;
    }

    // --------------------------------------------------------------------------

    static StringBuilder pic_builder(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append("\n");
        sb.append(b);
        sb.append("\n");
        sb.append(c);
        sb.append("\n");
        return sb;
    }

    // --------------------------------------------------------------------------

    // 1-2, 1-3, 2-3 чет
    // 1-3, 1-2, 2-3 не чет

    // --------------------------------------------------------------------------

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int tower_length = 10; // кол-во элементов в башне
        Stack<Integer> first_tower = tower_builder(tower_length, true);
        Stack<Integer> second_tower = tower_builder(tower_length, false);
        Stack<Integer> three_tower = tower_builder(tower_length, false);
        System.out.println("---------------------------------");
        System.out.println(pic_builder(first_tower, second_tower, three_tower));

        if ((first_tower.size()) % 2 == 0) {
            while (first_tower.size() > 1 | second_tower.size() > 1) {

                // первый ход

                if (first_tower.peek() > three_tower.peek()) {
                    if (three_tower.peek() == 0) {
                        three_tower.push(first_tower.pop());
                    } else {
                        first_tower.push(three_tower.pop());
                    }
                } else {
                    if (first_tower.peek() == 0) {
                        first_tower.push(three_tower.pop());
                    } else {
                        three_tower.push(first_tower.pop());
                    }
                }

                System.out.println(pic_builder(first_tower, second_tower, three_tower));

                // второй ход

                if (first_tower.peek() == 0 & second_tower.peek() == 0) {
                    break;
                } else {

                    if (first_tower.peek() > second_tower.peek()) {
                        if (second_tower.peek() == 0) {
                            second_tower.push(first_tower.pop());
                        } else {
                            first_tower.push(second_tower.pop());
                        }
                    } else {
                        if (first_tower.peek() == 0) {
                            first_tower.push(second_tower.pop());
                        } else {
                            second_tower.push(first_tower.pop());
                        }
                    }
                }
                System.out.println(pic_builder(first_tower, second_tower, three_tower));

                // третий ход

                if (three_tower.peek() > second_tower.peek()) {
                    if (second_tower.peek() == 0) {
                        second_tower.push(three_tower.pop());
                    } else {
                        three_tower.push(second_tower.pop());
                    }
                } else {
                    if (three_tower.peek() == 0) {
                        three_tower.push(second_tower.pop());
                    } else {
                        second_tower.push(three_tower.pop());
                    }
                }
                System.out.println(pic_builder(first_tower, second_tower, three_tower));
            }

        } else {

            while (first_tower.size() > 1 | second_tower.size() > 1) {

                // первый ход

                if (first_tower.peek() > second_tower.peek()) {
                    if (second_tower.peek() == 0) {
                        second_tower.push(first_tower.pop());
                    } else {
                        first_tower.push(second_tower.pop());
                    }
                } else {
                    if (first_tower.peek() == 0) {
                        first_tower.push(second_tower.pop());
                    } else {
                        second_tower.push(first_tower.pop());
                    }
                }
                System.out.println(pic_builder(first_tower, second_tower, three_tower));

                // второй ход

                if (first_tower.peek() > three_tower.peek()) {
                    if (three_tower.peek() == 0) {
                        three_tower.push(first_tower.pop());
                    } else {
                        first_tower.push(three_tower.pop());
                    }
                } else {
                    if (first_tower.peek() == 0) {
                        first_tower.push(three_tower.pop());
                    } else {
                        three_tower.push(first_tower.pop());
                    }
                }
                System.out.println(pic_builder(first_tower, second_tower, three_tower));

                // третий ход

                if (three_tower.peek() > second_tower.peek()) {
                    if (second_tower.peek() == 0) {
                        second_tower.push(three_tower.pop());
                    } else {
                        three_tower.push(second_tower.pop());
                    }
                } else {
                    if (three_tower.peek() == 0) {
                        three_tower.push(second_tower.pop());
                    } else {
                        second_tower.push(three_tower.pop());
                    }
                }
                System.out.println(pic_builder(first_tower, second_tower, three_tower));

            }

            System.out.println(pic_builder(first_tower, second_tower, three_tower));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Затраты по времени: " + (endTime - startTime) + "ms");
    }
}