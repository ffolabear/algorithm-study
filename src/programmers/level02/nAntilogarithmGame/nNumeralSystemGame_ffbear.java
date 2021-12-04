package programmers.level02.nAntilogarithmGame;

public class nNumeralSystemGame_ffbear {

    public String solution(int n, int t, int m, int p) {

        String answer = "";

        String list = "";

        for (int i = 0; i <= m * t; i++) {
            list += new StringBuffer(convert(n, i)).reverse().toString();
        }

        System.out.println(list);

        for (int i = 0; i < t; i++) {
            answer += String.valueOf(list.charAt(m * i + p - 1));


        }

        return answer;
    }

    static String convert(int n, int num) {

        String ans = "";

        if (num == 0) {

            return "0";
        }


        while (num != 0) {

            if (num % n >= 10) {
                ans += String.valueOf((char) (num % n + 55));
            } else {
                ans += String.valueOf(num % n);
            }
            num /= n;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int n = 2;
//        int t = 4;
//        int m = 2;
//        int p = 1;

        int n = 16;
        int t = 16;
        int m = 2;
        int p = 1;

        nNumeralSystemGame_ffbear sol = new nNumeralSystemGame_ffbear();
        sol.solution(n, t, m, p);


    }
}
