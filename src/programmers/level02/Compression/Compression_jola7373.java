package programmers.level02.Compression;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compression_jola7373 {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> hashmap = new HashMap<>();
        char alpha = 'A';
        for(int i=1; i < 27; i++){
            hashmap.put(Character.toString(alpha), i);
            alpha++;
        }
        int dictionary_index= 27;
        int i=0;
        while(i < msg.length()){
            int index = i+1;
            String temp="";
            while (index < msg.length()+1){
                temp = msg.substring(i,index);
                if(!hashmap.containsKey(temp)){
                    hashmap.put(temp, dictionary_index);
                    dictionary_index++;
                    break;
                }
                index++;
            }
            // System.out.println(hashmap.get(msg.substring(i,index-1)));
            answer.add(hashmap.get(msg.substring(i,index-1)));
            i = index-1;
        }
        return answer;
    }
}
