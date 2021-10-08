package programmers.level02.EliminationByGrouping;
import java.util.Stack;

class EliminationByGrouping_gytj2031{
    public static int solution(String s){
	    Stack<Character> stack = new Stack<>();
	    int idx = 0;
	    
	    while(idx < s.length()) {
	    	if(stack.empty() || stack.peek() != s.charAt(idx)) {
		    	stack.push(s.charAt(idx));
		    }
	    	else{stack.pop();}
		    idx++;
	    }
	    
	    if (stack.empty()) {return 1;}    
	    return 0;	
    }
    public static void main(String[] args) {
    	System.out.println(solution("bcdccccccdcb"));
    }
}