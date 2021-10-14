package programmers.level02.newsClustering;
import java.util.ArrayList;
import java.util.HashSet;

public class NewsClustering_jola7373 {

    class Solution {
        public int solution(String str1, String str2) {
            int answer = 0;

            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();

            ArrayList<String> list1 = toList(str1);
            ArrayList<String> list2 = toList(str2);
            ArrayList<String> union = new ArrayList<>();
            //둘다 공집합일경우
            if(str1.isEmpty() && str2.isEmpty()){
                return 1;
            }

            HashSet<String> set = new HashSet<String>();
            set.addAll(list1);
            set.addAll(list2);

            //합집합 구하기 위해 한 arraylist에 다 더해준다.
            union.addAll(list1);
            union.addAll(list2);


            //중복제거
            HashSet<String> hash = new HashSet<String>();
            hash.addAll(union);

            //교집합
            list1.retainAll(list2);

            answer = (int)(((double)list1.size()/(double)hash.size()) *65536);

            return answer;
        }

        //2글자씩 잘라서 리스트 만들어준다.
        public ArrayList<String> toList(String str){
            ArrayList<String> list = new ArrayList<>();
            int pre = 0;
            int post =2;
            String restr = str.replaceAll("[^a-z]","");
            while(list.size() < restr.length()-1){
                list.add(restr.substring(pre,post));
                post+=1;
                pre+=1;
            }return list;
        }
    }
}
