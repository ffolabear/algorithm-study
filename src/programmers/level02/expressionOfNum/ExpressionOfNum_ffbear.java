package programmers.level02.expressionOfNum;

public class ExpressionOfNum_ffbear {

    public int solution(int n) {

        int answer = 0;


        for (int i = 1; i <= n; i++) {
            int sum = 0;

            for (int j = i; j <= n; j++) {

                sum += j;

                if (sum == n) {
                    answer++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }

        }
        System.out.println(answer);

        return answer;
    }


    public static void main(String[] args) {

        int n = 15;
        ExpressionOfNum_ffbear sol = new ExpressionOfNum_ffbear();
        sol.solution(n);


    }
}
