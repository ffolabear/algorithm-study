package Baekjoon.practice.bruteForce.sumOfPartialSequence_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182_ffbear {

    static int N, S;
    static int count = 0;
    static int[] nums;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];

        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        dfs(0, 0);

        if (S == 0) {
            count--;
        }

        System.out.println(count);

    }

    static void dfs(int index, int sum) {

        if (index == N) {
            if (sum == S) {
                count ++;
            }
            return;
        }

        dfs(index + 1, sum + nums[index]);
        dfs(index + 1, sum);

    }

}
