package programmers.level02.lifeboat;

import java.util.Arrays;
import java.util.Collections;

class Lifeboat_gytj2013 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        int len = people.length;
        
        Integer[] weight = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(weight, Collections.reverseOrder());
        
        int left;
        int least=len-1;
        for(int i=0; i<weight.length; i++) {
        	if(weight[i]==0) {continue;}
        	left=limit-weight[i];
        	if(left >= weight[least]) {
        		weight[least]=0;
        		least--;
        	}
        	answer++;
        }
        return answer;
    }
}