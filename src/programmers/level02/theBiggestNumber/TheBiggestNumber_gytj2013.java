package programmers.level02.theBiggestNumber;

import java.util.Arrays;

class TheBiggestNumber_gytj2013 {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];

        for(int i = 0 ; i < numbers.length ; i++) {
            num[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(num, (o1, o2) -> -(o1+o2).compareTo(o2+o1));

        for(String i : num) {
            answer += i;
        }

        if(answer.charAt(0) == '0') answer = "0";

        return answer;
    }
}
