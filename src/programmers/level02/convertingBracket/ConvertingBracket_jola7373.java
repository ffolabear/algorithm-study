package programmers.level02.convertingBracket;
import java.util.Stack;

public class ConvertingBracket_jola7373 {
    class Solution {
        int pos = 0;
        boolean isCorrect(String str){//균형잡인, 올바른 인지 구분
            boolean ret = true;
            int open = 0, close=0;
            Stack<Character> stack = new Stack<>();

            for(int i =0; i < str.length(); i++){
                if(str.charAt(i)=='('){
                    stack.push('(');
                    open++;
                }else{
                    close++;
                    if(stack.empty()){
                        ret = false;
                    }else{
                        stack.pop();
                    }
                }
                if(close==open){//가장 짧은 균형잡힌
                    pos = i+1;
                    return ret;
                }
            }

            return true;
        }
        public String solution(String p) {
            String answer = "";
            if(p.isEmpty()){
                return answer;
            }
            boolean correct = isCorrect(p);

            String u = p.substring(0,pos);//균형잡힌 문자열
            String v = p.substring(pos,p.length());//나머지

            if(correct){
                return u+solution(v);
            }

            //올바른 괄호 문자열이 아님
            answer = "(" + solution(v) + ")";
            for(int i =1; i < u.length()-1; i++){
                if(u.charAt(i)=='('){
                    answer +=')';
                }else{
                    answer +='(';
                }
            }
            return answer;
        }
    }
}
