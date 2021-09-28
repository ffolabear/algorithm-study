class Solution {
    public static int solution(String s) {
        int answer = s.length();
        for(int i=1; i<=s.length()/2;i++) {
	       	String tmp = "";
	       	int sum = 0;
	       	int cnt = s.length();
	       	for(int j=0;j<s.length()/i;j++) {
	       		if (tmp.equals(s.substring(j*i,(j*i)+i))) {
	       			sum++;
	       		}
	       		else {
	       			tmp = s.substring(j*i,(j*i)+i);
	       			if(sum > 0) {
	       				cnt-=(sum*i-1);
	       				cnt+=(int)Math.log10(sum+1);
	       				sum = 0;
	       			}
        		}
	        }if(sum > 0) {cnt-=(sum*i-1);cnt+=(int)Math.log10(sum+1);}
	    if(cnt<answer) {answer=cnt;}
	    if (answer<=i+1) {break;}
	    }
        return answer;
    }
}