package programmers.level02.vowelDictionary;

public class vowelDictionary_jola7373 {
    class Solution {
        public int solution(String word) {
            int answer = word.length();
            String str = "AEIOU";
            int[] x = {781,156,31,6,1};

            for(int i=0; i< word.length();i++){
                answer += x[i] * str.indexOf(word.charAt(i));
            }
            return answer;
        }
    }
}
