package programmers.level02.maxAndMin;

import java.util.StringTokenizer;

public class MaxAndMin_ffbear {

    public String solution(String s) {

        int[] nums = new int[s.split(" ").length];
        StringTokenizer st = new StringTokenizer(s);

        int index = 0;

        while (st.hasMoreTokens()) {
            nums[index] = Integer.parseInt(st.nextToken());
            index++;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }



        String answer = min + " " + max;
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {

        String s = "1 2 3 4";
//        String s = "-1 -2 -3 -4";
//        String s = "-1 -1";

        MaxAndMin_ffbear sol = new MaxAndMin_ffbear();
        sol.solution(s);

    }
}
