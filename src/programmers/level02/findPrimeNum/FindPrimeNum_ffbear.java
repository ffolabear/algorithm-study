package programmers.level02.findPrimeNum;

import java.util.HashSet;
import java.util.Set;

public class FindPrimeNum_ffbear {

    //만든 소수를 저장할 배열
    static Set<Integer> arr = new HashSet<>();
    static boolean[] visited;

    static String[] comb;

    //문자열 자른 배열
    static String[] nums;



    public int solution(String numbers) {

        int answer = 0;

        nums = numbers.split("");
        comb = new String[nums.length];
        visited = new boolean[nums.length];


        for (int i = 1; i <= numbers.length(); i++) {


            combination(0, i, numbers);

        }

        answer = arr.size();
        return answer;
    }

    static void combination(int current, int length, String numbers) {

        if (current == length) {
            StringBuilder sb = new StringBuilder();
            for (String s : comb) {
                sb.append(s);
            }

            int res = Integer.parseInt(sb.toString().replaceAll("null",""));

            if (isPrime(res)) {
                arr.add(res);
            }

        } else {

            for (int i = 0; i < numbers.length(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    comb[current] = nums[i];
                    combination(current + 1, length, numbers);
                    visited[i] = false;
                }

            }


        }

    }

    static boolean isPrime(int res) {
        if (res == 1 || res == 0) {
            return false;
        }

        for (int i = 2; i < res; i++) {
            if (res % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String numbers = "17";
        FindPrimeNum_ffbear sol = new FindPrimeNum_ffbear();
        sol.solution(numbers);

    }
}
