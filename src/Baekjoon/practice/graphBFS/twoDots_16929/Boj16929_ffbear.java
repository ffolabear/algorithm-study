package Baekjoon.practice.graphBFS.twoDots_16929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16929_ffbear {

    static int N, M;
    static int initX, initY;
    static String[][] board;
    static boolean[][] visited;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new String[N][M];


        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                visited = new boolean[N][M];

                initX = i;
                initY = j;

                if (dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");

    }

    static boolean dfs(int x, int y, int count) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && board[x][y].equals(board[nx][ny])) {
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (dfs(nx, ny, count + 1)) {
                        return true;
                    }

                } else {
                    if (count >= 4 && initX == nx && initY == ny) {
                        return true;
                    }
                }
            }

        }

        return false;
    }

}
