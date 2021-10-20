package programmers.level02.theBiggestNumber;
import java.util.*;
public class TheBiggestNumber_carnival77 {
    public String solution(int[] numbers) {
        String answer = "";

        String[] str_nums = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            str_nums[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(str_nums, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });

        if(str_nums[0].equals("0")) return "0";

        for(String s : str_nums) answer += s;

        return answer;
    }
}
