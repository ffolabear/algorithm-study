package programmers.level02.nAntilogarithmGame;

class NAntilogarithmGame_gytj2013 {
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String tmp = "01";
        int cnt = 2;
        int cnt2;
        
        while(true) {
        	String res = "";
        	cnt2=cnt;
        	while(cnt2 > 0) {
        		if(cnt2 % n < 10) {
	        		res = (cnt2%n)+res;
        		}else {
        			res = (char)(cnt2%n-10+'A')+res;
        		}
        		cnt2/=n;
        	}
        	tmp += res;
        	if(tmp.length()>=(t-1)*m+p) {break;}
        	cnt++;
        }
        for(int i=p-1; i<(t-1)*m+p; i+=m) {
        	answer += tmp.charAt(i);
        }
      
        return answer;
    }
}