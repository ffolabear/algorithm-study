package programmers.level02.jadenCaseStr;

class JadenCaseStr_gytj2013 {
    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        s = s.toLowerCase();
        
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i)==' ') {
        		answer.append(" ");
        		continue;
        	}
        	int idx = s.indexOf(" ",i);
        	System.out.println(idx+","+i);
        	if(idx==-1) {idx=s.length();}
        	if(idx>i) {
        		answer.append(s.substring(i, i+1).toUpperCase());
        		if(idx>i+1) {answer.append(s.substring(i+1, idx));}
        	}
        	i=idx-1;
        }
        
        return answer.toString();
    }
}