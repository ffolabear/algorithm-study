package programmers.level02.countryOf124;

public class CountryOf124_ffbear {

    public String solution(int n) {


        StringBuilder answer = new StringBuilder();

        while (n > 0) {

            int remainder = n % 3;
            n = n / 3;

            if (remainder == 0) {
                remainder = 4;
                n -= 1;
            }

            answer.insert(0, remainder);
        }


        return answer.toString();
    }

    public static void main(String[] args) {

        int N = 10;
//        int N = 2;
//        int N = 3;
//        int N = 4;

        CountryOf124_ffbear sol = new CountryOf124_ffbear();
        sol.solution(N);

    }
}
