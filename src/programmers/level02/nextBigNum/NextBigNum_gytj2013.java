package programmers.level02.nextBigNum;

class NextBigNum_gytj2013{
    public static int solution(int n) {
    	int cnt = Integer.bitCount(n);
    	
    	while(true) {
    		n++;
    		if(cnt==Integer.bitCount(n)) {
    			return n;
    		}
    	}
    }
}