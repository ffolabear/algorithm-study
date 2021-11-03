package truckCrossingBridge;
import java.util.Queue;
import java.util.LinkedList;
public class TruckCrossingBridge_jola7373 {


    class Solution {
        public static int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int curr = 0;

            Queue <Integer> bridge = new LinkedList<Integer>();
            //무게가 넘는지 않넘는지 체크해준다.
            //건너는데 걸리는

            for(int i=0; i< truck_weights.length; i++){
                while(true){//차를 더해줄때만 i가 늘어 날 수 있게 while loop으로 감싼다
                    if(bridge.isEmpty()){
                        bridge.add(truck_weights[i]);
                        curr+=truck_weights[i];
                        answer++;
                        System.out.println(answer);
                        break;
                    } else if(bridge_length == bridge.size()){
                        curr-=bridge.poll();//그냥 앞에 있는것만 빼주기에 시간 추가할 필요X
                    }else{
                        if(curr+ truck_weights[i] <= weight){
                            bridge.add(truck_weights[i]);
                            curr+=truck_weights[i];
                            answer++;
                            System.out.println(answer);
                            break;
                        }else{
                            //bridge에 있는 트럭이 다리를 다 건너게 한다.
                            bridge.add(0);
                            answer++;
                            System.out.println(answer);
                        }
                    }

                }

            }
            return answer+ bridge_length;
        }
    }
}
