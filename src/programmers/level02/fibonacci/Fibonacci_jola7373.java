package programmers.level02.fibonacci;

public class Fibonacci_jola7373 {
    public long solution(int n) {
        long answer = 0;
        long d[] = new long [n+1];
        d[0] = 0;
        d[1] = 1;
        //dp의 bottom up방식으로 해결
        for(int i=2; i < n+1; i++){
            d[i] = (d[i-1]+ d[i-2]) % 1234567;
        }
        answer = d[n];
        return answer;
    }
}
