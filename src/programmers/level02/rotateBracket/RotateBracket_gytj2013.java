package programmers.level02.rotateBracket;
import java.util.Stack;

class RotateBracket_gytj2013 {
	static int answer = 0;
    public static int solution(String s) {
       int len = s.length();
       
       if(len%2==1) {return 0;}
       
       check(s, len);
       for(int i=1; i<len; i++) {
    	   s = s.substring(1)+s.charAt(0);
    	   check(s, len);
       }
 
        return answer;
    }
    private static void check(String s, int len) {
    	Stack<Character> stack = new Stack<>();
    	
    	for(int i=0; i<len; i++) {
    		char c = s.charAt(i);
    		if(c=='['|c=='{'|c=='(') {
    			stack.push(c);
    		}
    		else {
    			if(stack.empty()) {return;}
    			char r = stack.pop();
    			if(c==']' & r!='[') {return;}
    			if(c=='}' & r!='{') {return;}
    			if(c==')' & r!='(') {return;}
    		}
    	}
    	answer++;
    	return;
    	
	}
}