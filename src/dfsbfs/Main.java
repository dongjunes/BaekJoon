package dfsbfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by dongjunekim on 2017-09-26.
 */
public class Main {
    static int adjacencyMatrix[][];//인접행렬
    static boolean isVisit[];//확인
    static int vCount;//정점
    static int eCount;//간선
    static int start;


    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        adjacencyMatrix = new int[1001][1001];
        isVisit = new boolean[10001];
        vCount = s.nextInt();
        eCount = s.nextInt();
        start = s.nextInt();
        int edge1, edge2;
        for (int i = 0; i < eCount; i++) {
            edge1 = s.nextInt();
            edge2 = s.nextInt();
            adjacencyMatrix[edge1][edge2] = 1;
            adjacencyMatrix[edge2][edge1] = 1;

        }
        dfs(start);
        for (int i = 0; i < isVisit.length; i++) {
            isVisit[i] = false;
        }
        System.out.println();
        bfs(start);


    }


    public static void dfs(int n) {
        isVisit[n] = true;
        System.out.print(n + " ");
        for (int i = 1; i <= vCount; i++) {
            if (adjacencyMatrix[n][i] == 1 && !isVisit[i]) {
                dfs(i);
            }
        }

    }

    public static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(n);
        isVisit[n] = true;
        System.out.print(n + " ");

        while (!queue.isEmpty()) {
            n = queue.poll();
            for (int i = 0; i < vCount + 1; i++) {
                if (adjacencyMatrix[n][i] == 1 && !isVisit[i]) {
                    queue.offer(i);
                    isVisit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }


}


