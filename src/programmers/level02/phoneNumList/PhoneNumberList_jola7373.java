package programmers.level02.phoneNumList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class PhoneNumberList_jola7373 {
    class Solution {
        public boolean solution(String[] phone_book) {

            //hashmap을 통해 더 쉽게 겹치는 부분을 찾을 수 있어 사용
            Map<String, String> map = new HashMap<String, String>();

            //그 후 map에 string을 하나씩 넣어준다.
            for(String temp : phone_book){
                map.put(temp, temp);
            }

            //마지막으로 접두사가 있는지 확인해줍니다.
            for(String str : phone_book){
                for(int index = 0; index < str.length(); index++){
                    //접두어는 앞에만 있으므로 0고정
                    String temp = str.substring(0, index);
                    if( map.containsKey( temp )){
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
