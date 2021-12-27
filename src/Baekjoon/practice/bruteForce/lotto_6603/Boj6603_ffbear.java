package Baekjoon.practice.bruteForce.lotto_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj6603_ffbear {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = bf.readLine();
            if (input.equals("0")) {
                break;
            }

            String[] strArr = input.split(" ");

            int k = Integer.parseInt(strArr[0]);
            int[] intArr = new int[k];
            boolean[] visited = new boolean[k];

            for (int i = 0; i < intArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i + 1]);
            }


            combination(intArr, visited,0, 0, 6);
            System.out.println();


        }

    }

    static void combination(int[] intArr, boolean[] visited, int idx, int count, int k) {

        if (count == k) {
            for (int i = 0; i < intArr.length; i++) {
                if (visited[i]) {
                    System.out.print(intArr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < intArr.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            combination(intArr, visited, i, count + 1, k);
            visited[i] = false;
        }


    }
}
