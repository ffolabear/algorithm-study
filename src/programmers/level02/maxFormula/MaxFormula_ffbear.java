package programmers.level02.maxFormula;

import java.util.ArrayList;

public class MaxFormula_ffbear {

    static ArrayList<String> list;
    static long[] nums;

    public long solution(String expression) {

        String temp = "";

        String regex = "[^0-9]";
        temp = expression.replaceAll(regex, " ");
        list = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            if (String.valueOf(expression.charAt(i)).matches(regex)) {
                list.add(String.valueOf(expression.charAt(i)));
            }
        }

        String[] numsStr = temp.split(" ");
        nums = new long[numsStr.length];

        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Long.parseLong(numsStr[i]);
            System.out.println(nums[i]);
        }





        long answer = 0;
        return answer;
    }



    static Long calculation(Long num1, Long num2, String operator) {

        long res = 0;
        if (operator.equals("-")) {
            res = num1 - num2;
        } else if (operator.equals("*")) {
            res = num1 * num1;
        } else if (operator.equals("+")) {
            res = num1 + num2;
        }

        return res;
    }

    public static void main(String[] args) {

        String expression = "100-200*300-500+20";

        MaxFormula_ffbear sol = new MaxFormula_ffbear();
        sol.solution(expression);
    }
}
