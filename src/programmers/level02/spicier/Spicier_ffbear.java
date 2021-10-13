package programmers.level02.spicier;

import java.util.PriorityQueue;

public class Spicier_ffbear {

    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {

            priorityQueue.add(scoville[i]);
        }

        int answer = 0;


        int mixed = 0;

        while (priorityQueue.peek() < K) {

            if (priorityQueue.size() > 1) {
                mixed = priorityQueue.poll() + priorityQueue.poll() * 2;
                priorityQueue.add(mixed);
                answer++;
            } else {
                answer = -1;
            }

        }

        System.out.println(priorityQueue);

        return answer;
    }


    public static void main(String[] args) {


        int[] scovile = {1, 2, 3, 9, 10, 12};
        int K = 7;

        Spicier_ffbear sol = new Spicier_ffbear();
        sol.solution(scovile, K);

    }
}
