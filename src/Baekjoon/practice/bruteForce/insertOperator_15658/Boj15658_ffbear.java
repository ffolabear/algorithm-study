package Baekjoon.practice.bruteForce.insertOperator_15658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15658_ffbear {

    static int N;
    static int[] operators = new int[4];
    static int[] nums;

    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //숫자의 갯수
        N = Integer.parseInt(br.readLine());

        //입력받은 숫자
        String[] numbers = br.readLine().split(" ");
        nums = new int[numbers.length];



        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        operators[0] = Integer.parseInt(st.nextToken());
        operators[1] = Integer.parseInt(st.nextToken());
        operators[2] = Integer.parseInt(st.nextToken());
        operators[3] = Integer.parseInt(st.nextToken());

        dfs(nums[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);


    }

    static void dfs(int num,int idx) {

        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);

            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operators[i] == 0) {
                continue;
            }

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
