package programmers.level02.spicier;
import java.util.PriorityQueue;

public class Spicier_jola7373 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> heap = new PriorityQueue();
            for(int one:scoville){
                heap.offer(one);
            }while(heap.peek() < K){
                if(heap.size() < 2){
                    return -1;
                }
                int hottest = heap.poll();
                int hot = heap.poll();
                heap.add(hottest + hot*2);
                answer++;
            }
            return answer;
        }
    }
}
