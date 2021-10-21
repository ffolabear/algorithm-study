package programmers.level02.theBiggestNumber;
import java.util.Arrays;
import java.util.Comparator;
public class theBiggestNumber_jola7373 {
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            String [] temp = new String[numbers.length];
            //우선 숫자들을 string array에 담아준다.
            for ( int i = 0 ; i < numbers.length; i++){
                temp[i] = String.valueOf(numbers[i]);
            }
            //바로 정렬을 하면 자릿수가 다른 숫자들은 우리가 원하는 방식대로 처리 불가능
            Arrays.sort(temp, new Comparator<String>(){//comparator을 사용해 우리가 원하는 방식 적용
                @Override
                public int compare(String o1, String o2){//두
                    return ((o2+o1).compareTo(o1+o2));
                }
            });
            //가장 큰 수가 0이면 전체가 0이므로 만약 그렇다면 return 0
            if(temp[0].equals("0")){
                return "0";
            }
            //answer에 순서대로 넣어준다.
            for(String n: temp){
                answer += n;
            }

            return answer;
        }
    }
}
