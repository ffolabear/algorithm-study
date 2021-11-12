package programmers.level02.snail;

class Snail_gytj2013{
    public static int[] solution(int n) {
    	double len = ((n+1)/2.0)*n;
        int[] answer = new int[(int) len];
        
        int idx=0;
        int start=n;
        int plus=0;
        int value=1;
        
        while(true) {
	        for(int i=0; i<start; i++) {
	        	answer[idx] = value;
	        	value++;
	        	plus++;
	        	if(i==start-1) {break;}
	        	idx+=plus;
	        }
	        idx++;
	        start--;
	        
	        for(int i=0; i<start; i++) {
	        	answer[idx] = value;
	        	value++;
	        	if(i==start-1) {break;}
	        	idx++;
	        }
	        start--;
	        
	        for(int i=0; i<start; i++) {
	        	idx-=plus;
	        	answer[idx] = value;
	        	value++;
	        	plus--;
	        }
	        start--;
	        idx+=plus;
	        
	        if(value>len) {break;}
        }
        
        return answer;
    }
}