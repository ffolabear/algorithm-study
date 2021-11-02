package programmers.level02.truckCrossingBridge;
import java.util.LinkedList;
import java.util.Queue;

class TruckCrossingBridge_gytj2013{
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
    	Queue<Integer> q = new LinkedList<>();
        int answer = 1;
        int tmp = truck_weights[0];
        int idx=1;
        q.add(truck_weights[0]);
        
        while(true) {
        	answer++;
        	if(idx==truck_weights.length) {break;}
        	if(q.size()==bridge_length) {tmp-=q.poll();}
        	if(tmp+truck_weights[idx]<=weight) {
        		tmp+=truck_weights[idx];
        		q.offer(truck_weights[idx]);
        		idx++;
        	}
        	else {q.offer(0);}
        }
        answer+=bridge_length-1;
        
        return answer;
    }
}