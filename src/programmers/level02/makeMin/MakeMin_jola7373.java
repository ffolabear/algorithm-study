package programmers.level02.makeMin;

import java.util.Arrays;

public class MakeMin_jola7373 {
    public int solution(int []A, int []B)
    {
        int answer = 0;
        /*
         * 가장 큰값과 가장 작은값을 곱해 더한값이 결과적으로는 가장 작은 결과를
         * 낼 수 있다.
         */


        //먼저 정렬을 해준다
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i< A.length; i++){
            answer += A[A.length-i-1] * B[i];
        }

        return answer;
    }
}
