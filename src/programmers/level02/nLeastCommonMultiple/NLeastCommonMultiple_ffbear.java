package programmers.level02.nLeastCommonMultiple;

public class NLeastCommonMultiple_ffbear {

    public int solution(int[] arr) {

        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer * arr[i] / gcd;

        }

        return answer;
    }

    static int gcd(int a, int b) {

        int bigger = Math.max(a, b);
        int smaller = Math.min(a, b);

        while (bigger % smaller != 0) {

            int r = bigger % smaller;
            bigger = smaller;
            smaller = r;

        }

        return smaller;
    }

    public static void main(String[] args) {

        int[] arr = {2, 6, 8, 14};
        NLeastCommonMultiple_ffbear sol = new NLeastCommonMultiple_ffbear();
        sol.solution(arr);

    }
}
