package programmers.level02.cache;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.Queue;

public class cache_jola7373 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            Queue<String> queue = new LinkedList<>();


            for(int i=0; i < cities.length; i++){
                String unify = cities[i].toUpperCase();
                if(queue.contains(unify)){
                    queue.remove(unify);
                    queue.add(unify);
                    answer+=1;
                }else{
                    if(queue.size() < cacheSize){
                        queue.add(unify);
                        answer+=5;
                    }else if(cacheSize==0){
                        answer+=5;
                    }else{
                        queue.poll();
                        queue.add(unify);
                        answer+=5;
                    }
                }

            }
            return answer;
        }
    }
}
