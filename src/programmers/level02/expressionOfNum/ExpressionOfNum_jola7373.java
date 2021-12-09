package programmers.level02.expressionOfNum;

public class ExpressionOfNum_jola7373 {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n];
        int total =0;
        for(int i=1; i <= n; i++){
            arr[i-1] = i;
        }
        for(int i=0; i < n;i++){
            int idx = i;
            while(idx < n && total < n){
                total += arr[idx];
                idx++;
            }
            if(total == n){
                answer++;
            }total =0;
        }

        return answer;
    }
}
