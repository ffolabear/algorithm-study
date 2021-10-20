package programmers.level02.printer;
import java.util.PriorityQueue;
import java.util.Collections;

public class Printer_jola7373 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 1;

            //collectios.reverseOrder을 사용해 큰 수가 앞에 오도록 만든다.
            PriorityQueue prior = new PriorityQueue<>(Collections.reverseOrder());
            for(int doc: priorities){//우선순위 큐에 옮긴다.
                prior.add(doc);
            }

            while(!prior.isEmpty()){//배열의 끝까지 간 후 다시 돌아온다.
                for(int i =0; i < priorities.length; i++){
                    if((int)prior.peek() == priorities[i]){
                        //prior에 나갈 순서가 저장되어 있으니 priorities에 있는 숫자와 비교후 같으면 빼준다.
                        if(location==i){//location에 있는거면 return
                            return answer;
                        }else{
                            prior.poll();
                            answer++;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
