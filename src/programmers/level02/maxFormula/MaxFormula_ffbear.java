package programmers.level02.maxFormula;

import java.util.ArrayList;

public class MaxFormula_ffbear {

    //연산자 배열
    static ArrayList<Character> oper;
    //숫자 배열
    static ArrayList<Long> nums;

    static char[] prior = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static long answer;

    public long solution(String expression) {

        String temp = "";
        answer = 0;

        String regex = "[^0-9]";
        temp = expression.replaceAll(regex, " ");
        oper = new ArrayList<Character>();

        for (int i = 0; i < expression.length(); i++) {
            if (String.valueOf(expression.charAt(i)).matches(regex)) {
                oper.add(expression.charAt(i));
            }
        }

        String[] numsStr = temp.split(" ");
        nums = new ArrayList<>();

        for (int i = 0; i < numsStr.length; i++) {
            nums.add(Long.parseLong(numsStr[i]));
        }


        dfs(0, new char[3]);

        System.out.println(answer);
        return answer;
    }

    static void dfs(int count, char[] order) {


        if (count == 3) {

            ArrayList<Long> numsClone = (ArrayList<Long>) nums.clone();
            ArrayList<Character> operClone = (ArrayList<Character>) oper.clone();

            for (int i = 0; i < order.length; i++) {
                for (int j = 0; j < operClone.size(); j++) {

                    if (order[i] == operClone.get(j)) {
                        Long res = calculation(numsClone.remove(j), numsClone.remove(j), order[i]);
                        numsClone.add(j, res);
                        operClone.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(numsClone.get(0)));
            return;
        }


        // 모든 우선순위 조합구하기.
        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                check[i] = true;
                order[count] = prior[i];
                dfs(count + 1, order);
                check[i] = false;
            }
        }

    }

    static Long calculation(long num1, long num2, char operator) {
        long res = 0;
        if (operator == '-') {
            return num1 - num2;
        } else if (operator == '*') {
            return num1 * num2;
        } else if (operator == '+') {
            return num1 + num2;
        }

        return res;
    }

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

        MaxFormula_ffbear sol = new MaxFormula_ffbear();
        sol.solution(expression);
    }
}
