package Baekjoon.practice.simulation.PopulationMovement_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16234_ffbear {

    static int N, L, R;

    static int[][] country;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        country = new int[N][N];

        int answer = 0;

        for (int i = 0; i < N; i++) {

            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(row[j]);
            }

        }

        while (true) {
            visited = new boolean[N][N];
            if (!checkMove()) {
                answer++;
            } else {
                break;

            }
        }

        //-----------------------------------------------------------------------------------

        for (int i = 0; i < country.length; i++) {
            for (int j = 0; j < country[i].length; j++) {
                System.out.print(country[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println(answer);
    }

    static boolean checkMove() {

        List<Node> visitList;

        boolean finish = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {

                    visitList = new LinkedList<>();
                    visitList.add(new Node(i, j));
                    int sum = dfs(i, j, visitList, 0);
                    if (visitList.size() > 1) {
                        movePeople(sum, visitList);
                        finish = false;
                    }
                }
            }
        }

        return finish;
    }

    static int dfs(int x, int y, List<Node> visitList, int sum) {

        visited[x][y] = true;
        sum = country[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }

            if (!visited[nx][ny]) {
                int difference = Math.abs(country[x][y] - country[nx][ny]);
                if (difference >= L && difference <= R) {
                    visitList.add(new Node(nx, ny));
                    sum += dfs(nx, ny, visitList, sum);
                }

            }

        }
        return sum;
    }

    static void movePeople(int sum, List<Node> visitList) {

        int avg = sum / visitList.size();
        for (Node node : visitList) {
            country[node.x][node.y] = avg;
        }
    }


}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

