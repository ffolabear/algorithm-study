package programmers.level02.rotateBracket;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class RotateBracket_ffbear {

    public int solution(String s) {

        int answer = 0;

        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }


        int max = s.length();

        String testcase = "";

        for (int i = 0; i < max - 1; i++) {

            Queue<Character> copy = new LinkedList<>(queue);

            while (!copy.isEmpty()) {
                testcase += copy.poll();
            }

            if (isValid(testcase)) {
                answer++;
            }

            Character ch = queue.poll();
            queue.add(ch);

            testcase = "";

        }

        return answer;
    }

    static boolean isValid(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            try{
                switch(str.charAt(i)){
                    case '[':
                        stack.add('[');
                        break;
                    case ']':
                        if(stack.peek() != '[') return false;
                        stack.pop();
                        break;
                    case '{':
                        stack.add('{');
                        break;
                    case '}':
                        if(stack.peek() != '{') return false;
                        stack.pop();
                        break;
                    case '(':
                        stack.add('(');
                        break;
                    case ')':
                        if(stack.peek() != '(') return false;
                        stack.pop();
                        break;
                }
            } catch(Exception e){
                return false;
            }


        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        String s = "[](){}";
//        String s =  "}]()[{";
//        String s =  "[)(]";
//        String s =  "}}}";

        RotateBracket_ffbear sol = new RotateBracket_ffbear();
        sol.solution(s);


    }
}
