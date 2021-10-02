package programmers.level02.CountryOf124;

public class CountryOf124_jola7373 {
    class Solution {
        public String solution(int n) {
            boolean check = false;
            String [] numbers = {"4","1","2"};
            String answer = "";
            while(n>0){
                answer = numbers[n%3] + answer;
                if(n%3 == 0) n--;
                n/=3;

            }
            return answer;
        }
    }
}
