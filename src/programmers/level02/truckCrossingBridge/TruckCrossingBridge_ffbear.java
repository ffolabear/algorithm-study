package programmers.level02.truckCrossingBridge;

import java.util.LinkedList;
import java.util.Queue;

public class TruckCrossingBridge_ffbear {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            //트럭이 다리를 지날떄는 3가지 경우

            while (true) {

                //다리가 비어있을때
                if (queue.isEmpty()) {
                    queue.add(truck_weights[i]);
                    sum += truck_weights[i];
                    time++;
                    break;

                    //다리가 트럭으로 꽉차있을때
                } else if (queue.size() == bridge_length) {
                    int temp = queue.poll();
                    sum -= temp;

                    //아직 다리에 트럭을 있음
                } else {

                    if (truck_weights[i] + sum <= weight) {
                        queue.add(truck_weights[i]);
                        sum += truck_weights[i];
                        time++;
                        break;

                    } else {
                        queue.add(0);
                        time++;
                    }

                }
            }


        }

        return time + bridge_length;
    }

    public static void main(String[] args) {

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weight = {7, 4, 5, 6};

        TruckCrossingBridge_ffbear sol = new TruckCrossingBridge_ffbear();
        sol.solution(bridge_length, weight, truck_weight);

    }


}
