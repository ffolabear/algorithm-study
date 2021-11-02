package programmers.level02.hIndex;
import java.util.Arrays;

class HIndex_gytj2013{
    public static int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        int h = 0;
        int idx = 0;
        Arrays.sort(citations);
        
       while(true) {
    	   if(idx>=n) {break;}
    	   if(h<=citations[idx]) {
    		   if(n-idx>=h) {
    			   answer = h;
    		   }
    		   h++;
    	   }
    	   else {
    		   idx++;
    	   }
       }   
        return answer;
    }
}