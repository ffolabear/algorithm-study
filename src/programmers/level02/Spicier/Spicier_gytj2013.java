package programmers.level02.Spicier;

import java.util.PriorityQueue;

class Spicier_gytj2013 {
    public static int solution(int[] scoville, int K) { 
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    	
    	for(int i=0 ; i<scoville.length;i++) {
    		priorityQueue.add(scoville[i]);
    	}
    	
    	int min = priorityQueue.poll();
    	int min2 = priorityQueue.poll();
    	int answer = 0;
    	
    	while(min < K) {
    		priorityQueue.add(min + (min2*2));
    		answer++;
    		min = priorityQueue.poll();
    		if(priorityQueue.size()<1) {
    			if(min < K) {return -1;}
    			break;
    			}
        	min2 = priorityQueue.poll();
    	}
    	
        return answer;
    }
    public static void main(String[] args) {
    	int[] scoville = {1, 2, 3};
    	int K = 7;
    	System.out.println(solution(scoville, K));
    }
}