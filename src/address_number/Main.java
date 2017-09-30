package address_number;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dongjunekim on 2017-09-27.
 */
public class Main {

    static int map[][];
    static int count[];
    static int address = 0;
    static int length;

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        length = s.nextInt();
        count = new int[25 * 25 + 10];
        map = new int[25 + 10][25 + 10];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                map[i][j] = s.nextInt();
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (map[i][j] == 1) {
                    address++;
                    dfs(i, j);

                }
            }
        }
        System.out.println(address);
        sorting();
        for (int i = 0; i < address; i++) {
            System.out.println(count[i]);
        }
    }

    public static void dfs(int n1, int n2) {
        count[address - 1]++;
        map[n1][n2] = 0;

        if (n1 > 0 && map[n1 - 1][n2] != 0) {//왼쪽
            dfs(n1 - 1, n2);
        }
        if (n1 < length - 1 && map[n1 + 1][n2] != 0) {//오른쪽
            dfs(n1 + 1, n2);
        }
        if (n2 > 0 && map[n1][n2 - 1] != 0) {//아래
            dfs(n1, n2 - 1);
        }
        if (n2 < length - 1 && map[n1][n2 + 1] != 0) {//위
            dfs(n1, n2 + 1);
        }
    }

    public static void sorting() {
        int i, j, temp;
        for (i = 0; i < address; i++) {
            for (j = 0; j < address - 1; j++) {
                if (count[j] > count[j + 1]) {
                    temp = count[j];
                    count[j] = count[j + 1];
                    count[j + 1] = temp;
                }

            }
        }
    }
}
