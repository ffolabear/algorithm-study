package programmers.level01.numStrAndEnglishWord;
import java.util.Arrays;

class NumStrAndEnglishWord_gytj2013{
    public int solution(String s) {
    	String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    	String tmp = "";
    	String answer = "";
  	
    	for(int i=0; i<s.length(); i++) {
    		if(Arrays.asList(num).contains(tmp)) {
				answer += Arrays.asList(num).indexOf(tmp);
				tmp = "";
			}
    		if(47<s.charAt(i) & s.charAt(i)<58) {
    			answer +=  s.charAt(i);
    		}
    		else {
    			tmp += s.charAt(i);
    		}
    	}
    	if(Arrays.asList(num).contains(tmp)) {
			answer += Arrays.asList(num).indexOf(tmp);
			tmp = "";
		}
    	
        return Integer.parseInt(answer);
    }
}