package programmers.level02.tuple;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;
public class Tuple_jola7373 {
    class Solution {
        //리턴타입을 사이즈조절이 가능한 arraylist로 바꿔줬다.
        public ArrayList<Integer> solution(String s) {
            ArrayList<Integer> answer = new ArrayList<>();

            //s의 초반 {{을 지워줬다.
            s=s.substring(2, s.length());
            //후반에 있는 }}을 제외하고 모든},{이 있는 곳은 새로운 숫자 묶음이니 구별하기 위해
            //- 으로 바꿔줬다.
            s = s.substring(0,s.length()-2).replace("},{","-");
            //-가 있는 곳을 기준으로 나누어 array에 넣어주었다.
            String str[] = s.split("-");

            //길이순으로 sort한다.
            Arrays.sort(str,new Comparator<String>(){
                public int compare(String s1, String s2){
                    return Integer.compare(s1.length(), s2.length());
                }
            });

            for(String a: str){
                //숫자 한개씩 array에 저장
                String [] temp = a.split(",");
                for(int i=0; i < temp.length; i++){
                    //Integer로 바꿔준다.
                    int n = Integer.parseInt(temp[i]);
                    //없는 값은 넣어준다.
                    if(!answer.contains(n)){
                        answer.add(n);
                    }
                }


            }

            return answer;
        }
    }
}
