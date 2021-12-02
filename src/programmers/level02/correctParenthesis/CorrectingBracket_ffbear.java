package programmers.level02.correctParenthesis;

import java.util.Stack;

public class CorrectingBracket_ffbear {

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
                stack.push('(');

            } else {
                right++;
                if (stack.isEmpty()) {
                    return false;

                } else {
                    stack.pop();
                }
            }
        }

        if (left == right) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {

//        String s = "()()";
        String s = "(()(";

        CorrectingBracket_ffbear sol = new CorrectingBracket_ffbear();

        System.out.println(sol.solution(s));

    }
}
