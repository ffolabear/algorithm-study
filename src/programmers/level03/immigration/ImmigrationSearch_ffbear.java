package programmers.level03.immigration;

import java.util.Arrays;

public class ImmigrationSearch_ffbear {

    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long min = 1;
        long max = (long) times[times.length - 1] * n;

        while (min <= max) {

            //이분 탐색을 위해 중간값을 지정
            long mid = (min + max) / 2;

            long finished = 0;

            //7, 10 , .....
            for (int i = 0; i < times.length; i++) {

                // 25 / 7 + 25 / 10
                finished += mid / times[i];
            }

            System.out.println(min + " " + mid + " " + max);

            if (finished < n) {
                min = mid + 1;
            } else {
                max = mid - 1;
                answer = mid;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        ImmigrationSearch_ffbear sol = new ImmigrationSearch_ffbear();
        sol.solution(n, times);

    }
}
