package programmers.level02.correctParenthesis;
import java.util.*;

class CorrectParenthesis_gytj2013 {
    static boolean solution(String s) {
    	Stack<Character> stack = new Stack<>();
        boolean answer = true;
        Character c;
        
        for(int i=0; i<s.length(); i++) {
        	c=s.charAt(i);
        	if(c=='(') {
        		stack.push(c);
        	}else if(!stack.isEmpty()){
        		stack.pop();
        	}else {
        		answer = false;
        		break;
        	}
        }
        if(!stack.isEmpty()) {
        	answer = false;
        }

        return answer;
    }
}