package programmers.level02.hIndex;

import java.util.*;

public class Hindex_carnival77 {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int n=citations.length;

        for(int i=0;i<n;i++){
            if(citations[i] >= n-i)
                return n-i;
        }


        return answer;
    }
}
