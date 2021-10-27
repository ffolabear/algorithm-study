package programmers.level02.matchPrediction;

public class MatchPrediction_ffbear {

    public int solution(int n, int a, int b) {

        int c = Math.min(a, b);
        int d = Math.max(a, b);

        int answer = 1;


        while (true) {

            if (c % 2 == 1 && d - c == 1) {

                break;
            }

            c = (c + 1) / 2;
            d = (d + 1) / 2;
            answer++;

        }

        return answer;
    }

    public static void main(String[] args) {

        int a = 4;
        int b = 7;
        int n = 8;


        MatchPrediction_ffbear sol = new MatchPrediction_ffbear();
        sol.solution(n, a, b);

    }

}
