package programmers.level02.onetwofourWorld;

import programmers.level02.NormalSquare.NormalSquare_carnival77;

public class onetwofourWorld_carnival77 {
    public String solution(int n) {

       String[] numbers={"4","1","2"};
       String answer="";

       while (n>0) {
           int remain = n % 3;
           n /= 3;

           if (remain == 0) n -= 1;

           answer = numbers[remain] + answer;
       }
        return answer;
    }

    public static void main(String[] args) {


        int n = 4;
        onetwofourWorld_carnival77 sol = new onetwofourWorld_carnival77();
        sol.solution(n);

    }
}
