package Baekjoon.practice.DP.moving_11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11048_ffbear {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N + 1][M + 1];

        for (int i = 1; i < maze.length; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j < maze[i].length; j++) {
                maze[i][j] = Integer.parseInt(row[j - 1]);
            }

        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                maze[i][j] = Math.max(maze[i][j] + maze[i][j - 1], maze[i][j] + maze[i - 1][j]);
            }
        }

        System.out.println(maze[N][M]);

    }

}
