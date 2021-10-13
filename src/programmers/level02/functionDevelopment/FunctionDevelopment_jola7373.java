package programmers.level02.functionDevelopment;
import java.util.Arrays;

public class FunctionDevelopment_jola7373 {

    
        class Solution {
            public int[] solution(int[] progresses, int[] speeds) {
                int[] lastday = new int[100];
                int day=0;
                for(int i =0; i < progresses.length; i++){
                    while((progresses[i] + (day*speeds[i])) < 100){
                        day++;
                    }
                    lastday[day-1]++;
                }
                return Arrays.stream(lastday).filter(i->i!=0).toArray();
            }
        }

}
