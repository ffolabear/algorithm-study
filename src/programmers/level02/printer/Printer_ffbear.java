package programmers.level02.printer;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer_ffbear {

    public int solution(int[] priorities, int location) {

        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int priority : priorities) {
            queue.offer(priority);
        }

        while (!queue.isEmpty()) {

            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    if (i == location) {
                        return answer;

                    }
                    answer++;
                    queue.poll();
                }
            }


        }

        return answer;
    }

    public static void main(String[] args) {

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

//        int[] priorities = {1, 1, 9, 1, 1, 1};
//        int location = 0;
        Printer_ffbear sol = new Printer_ffbear();
        sol.solution(priorities, location);

    }

}
