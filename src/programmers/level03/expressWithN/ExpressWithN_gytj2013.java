package programmers.level03.expressWithN;

class ExpressWithN_gytj2013 {
	static int answer = -1;
    public static int solution(int N, int number) {
    	
        if(N==number) {return 1;}
        if(number==1 | number==N*N | number==N+N | number==N*11) {return 2;}
        
       dp(N, number, 0, 0);
       
        return answer;
    }
    private static void dp(int N, int number, int cur, int cnt) {
    	if(cnt > 8) return;
    	if(cur==number) {
    		if(answer==-1) {answer = cnt;}
    		else answer=Math.min(answer, cnt);
    	}
    	int X = N;
    	for(int i=1; i<=8-cnt; i++) {  		
	    	dp(N, number, cur+X, i+cnt);
	    	dp(N, number, cur-X, i+cnt);
	    	dp(N, number, cur/X, i+cnt);
	    	dp(N, number, cur*X, i+cnt);
	    	X=(10*X)+N;
    	}
	}
}