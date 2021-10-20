package programmers.level02.convertingBracket;

import java.util.Stack;

public class ConvertingBracket_ffbear {

    static int index;

    public String solution(String p) {
        String answer = "";

        if (p.length() == 0) {
            return p;
        }

        boolean isValid = isCorrect(p);

        String u = p.substring(0, index);
        String v = p.substring(index, p.length());

        if (isValid) {
            answer = u + solution(v);

        } else {
            answer = "(" + solution(v) + ")";
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    answer += ")";
                } else {
                    answer += "(";
                }
            }
        }



        return answer;
    }

    static boolean isCorrect(String p) {

        boolean isValid = true;

        int left = 0;
        int right = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
                stack.push('(');

            } else {
                right++;
                //스택이 비어있다 = 짝이 맞지 않다.
                if (stack.isEmpty()) {
                    isValid = false;
                } else {
                    stack.pop();
                }
            }
            //최초로 같을떄가 가장 짧은 문자열 u
            if (left == right) {
                index = i + 1;
                return isValid;
            }

        }

        //사실 이부분 까지 도달하는 경우는 없음
        return true;
    }

    public static void main(String[] args) {

        String p = "(()())()";
        ConvertingBracket_ffbear sol = new ConvertingBracket_ffbear();
        sol.solution(p);


    }


}
