package programmers.level02.ConvertingBracket;

class ConvertingBracket_gytj2013 {
	 String answer = "";
	 public String solution(String w) {
		 if(w=="") {return "";}
		 int cnt = 0;
		 String u = "";
		 String v = "";
		 for(int i=0; i<w.length(); i++) {
			 if(w.charAt(i)=='(') {cnt++;}
			 else {cnt--;}
			 if(cnt==0) {
				u = w.substring(0, i+1);
				v = w.substring(i+1);
				break;
			}
		 }
		 if(check(u)) {answer += u + solution(v);}
		 else {answer += '(' + solution(v) + ')' + reverse(u);}
		 return answer;
	 }
	 
	 public Boolean check(String u) {
		 int cnt = 0;
		 for(int i=0; i<u.length(); i++) {
			 if(u.charAt(i)=='(') {cnt++;}
			 else {cnt--;}
			 if(cnt<0) {return false;}
		 }
		 return true;
	 }
	 
	private String reverse(String u) {
		String reverseU = "";
		for(int i=1; i<u.length()-1; i++) {
			if(u.charAt(i)=='(') {reverseU += ')';}
			else {reverseU += '(';}
		}
		return reverseU;
	}
}