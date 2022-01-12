package Baekjoon.practice.bruteForce.insertOperator_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888_ffbear {

    static int N;
    static int[] nums;
    static int[] operators = new int[4];

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];

        //숫자 입력 부분
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //연산자 입력부분
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operators.length; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }


        dfs(nums[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);

    }


    static void dfs(int num, int idx) {


        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);

            return;
        }


        for (int i = 0; i < 4; i++) {

            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {

                    case 0: dfs(num + nums[idx], idx + 1); break;
                    case 1: dfs(num - nums[idx], idx + 1); break;
                    case 2: dfs(num * nums[idx], idx + 1); break;
                    case 3: dfs(num / nums[idx], idx + 1); break;


                }

                operators[i]++;

            }

        }

    }

}
