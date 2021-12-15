package programmers.level03.immigration;

import java.util.Arrays;

class Immigration_gytj2013 {
    public static long solution(int n, int[] times) {
    	long answer = 0;
    	Arrays.sort(times);
        
        long left = 0;
        long right = (long)n*times[times.length-1];
        long mid = 0;;
        
        while(right>=left) {
        	long sum = 0;
        	mid = (left + right)/2;
        	for(int i=0; i<times.length; i++) {
        		sum += mid / times[i];
        	}
        	if(sum < n) {
        		left = mid+1;
        	}else {
        		right = mid-1;
        		answer = mid;
        	}
        }
   
        return answer;
    }
}