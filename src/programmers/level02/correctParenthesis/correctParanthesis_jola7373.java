package programmers.level02.correctParenthesis;
import java.util.LinkedList;
import java.util.Queue;

public class correctParanthesis_jola7373 {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> queue = new LinkedList();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '('){
                queue.add('(');
            }else{
                if(queue.isEmpty() || !queue.poll().equals('(')){
                    return false;
                }
            }
        }
        if(!queue.isEmpty()){
            answer = false;
        }
        return answer;
    }
}
