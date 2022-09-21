/* Написать программу, показывающую последовательность действий для игры “Ханойская башня” */

public class PE_less3_task1 {

    static Integer[] tower_builder(int a, Boolean c) {
        Integer[] tower_arr = new Integer[a];
        if (c) {
            for (int i = 0; i < tower_arr.length; i++) {
                tower_arr[i] = (i + 1);
            }
        } else {
            for (int i = 0; i < tower_arr.length; i++) {
                tower_arr[i] = 0;
            }
        }
        return tower_arr;
    }

    // --------------------------------------------------------------------------

    static StringBuilder pic_builder(Integer[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                sb.append(a[j][i]);
                sb.append("     ");
            }
            sb.append("\n");
        }
        return sb;
    }

    // --------------------------------------------------------------------------

    // 1-2, 1-3, 2-3 не чет
    // 1-3, 1-2, 2-3 чет

    static Integer[][] move(Integer[][] a_towers, Integer[][] moves) {
        for (int z = 0; z < moves.length; z++) {
            if (a_towers[2][0] == 0) {
                int k = moves[z][0];
                int j = 0;
                int n = moves[z][1];
                int i = 0;
                while (a_towers[k][j] == 0 & j != a_towers[k].length - 1) {
                    j++;
                }
                while (a_towers[n][i] == 0 & i != a_towers[n].length - 1) {
                    i++;
                }
                if (a_towers[k][j] < a_towers[n][i] | a_towers[n][i] == 0) {
                    if (a_towers[n][i] == 0) {
                        System.out.printf("Ход %d > %d", k + 1, n + 1);
                        System.out.println();
                        a_towers[n][i] = a_towers[k][j];
                        a_towers[k][j] = 0;
                    } else {
                        if (a_towers[k][j] != 0) {
                            System.out.printf("Ход %d > %d", k + 1, n + 1);
                            System.out.println();
                            a_towers[n][i - 1] = a_towers[k][j];
                            a_towers[k][j] = 0;
                        } else {
                            System.out.printf("Ход %d > %d", n + 1, k + 1);
                            System.out.println();
                            a_towers[k][j] = a_towers[n][i];
                            a_towers[n][i] = 0;
                        }
                    }
                } else {
                    System.out.printf("Ход %d > %d", n + 1, k + 1);
                    System.out.println();
                    a_towers[k][j - 1] = a_towers[n][i];
                    a_towers[n][i] = 0;
                }
                System.out.println("Результат хода:");
                System.out.println(pic_builder(a_towers));
            }
        }
        return a_towers;
    }

    // --------------------------------------------------------------------------

    public static void main(String[] args) {
        int tower_length = 5; // кол-во элементов в башне
        Integer[] first_tower = tower_builder(tower_length, true);
        Integer[] second_tower = tower_builder(tower_length, false);
        Integer[] three_tower = tower_builder(tower_length, false);
        Integer all_towers[][] = { first_tower, second_tower, three_tower }; // массив для всех башен сразу
        System.out.println(pic_builder(all_towers));
        if (first_tower.length % 2 != 0) {
            Integer moves[][] = { { 0, 2 },
                    { 0, 1 },
                    { 1, 2 } };
            while (all_towers[2][0] == 0) {
                move(all_towers, moves);
            }
        } else {
            Integer moves[][] = { { 0, 1 },
                    { 0, 2 },
                    { 1, 2 } };
            while (all_towers[2][0] == 0) {
                move(all_towers, moves);
            }
        }
    }
}
