package programmers.level02.englishChainGame;
import java.util.ArrayList;
import java.util.List;

public class EnglishChainGame_jola7373 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        List<String> word = new ArrayList<String>();

        for(int i =0; i < words.length; i++){
            //마지막 글자와 첫글자 비교
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || word.contains(words[i])){
                answer[0] = i%n + 1;//번호
                answer[1] = i/n + 1;//차례
                break;
            }
            word.add(words[i]);
        }
        return answer;
    }
}
