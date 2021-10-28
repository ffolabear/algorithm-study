package matchPrediction;


public class MatchPredictioin_jola7373 {
    static int answer = 1;
    class Solution
    {
        public int solution(int n, int a, int b)
        {

            if(a>b){
                recurssion(a,b);
            }else{
                recurssion(b,a);
            }
            return answer;
        }
        public int recurssion(int n, int m){
            if(n%2==0 && n == m+1){
                return answer;
            }
            answer++;
            return recurssion(n/2+n%2, m/2+m%2);
        }
    }
}
