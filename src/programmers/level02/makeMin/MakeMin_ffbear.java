package programmers.level02.makeMin;

import java.util.Arrays;
import java.util.Collections;

public class MakeMin_ffbear {

    public int solution(int[] A, int[] B) {

        int answer = 0;
        Integer[] covtB = new Integer[B.length];

        for (int i = 0; i < B.length; i++) {
            covtB[i] = B[i];
        }

        Arrays.sort(A);
        Arrays.sort(covtB, Collections.reverseOrder());


        for (int i = 0; i < A.length; i++) {
            answer += A[i] * covtB[i];
        }

        return answer;
    }

    public static void main(String[] args) {

//        int[] A = {1, 4, 2};
//        int[] B = {5, 4, 4};

        int[] A = {1, 2};
        int[] B = {3, 4};

        MakeMin_ffbear sol = new MakeMin_ffbear();
        sol.solution(A, B);

    }
}
