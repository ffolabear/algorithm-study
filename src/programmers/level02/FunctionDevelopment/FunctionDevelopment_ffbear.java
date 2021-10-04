package programmers.level02.FunctionDevelopment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment_ffbear {

    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> answer = new ArrayList<>();


        int[] time = new int[progresses.length];

        Queue<Integer> task = new LinkedList<>();


        for (int i = 0; i < speeds.length; i++) {

            int ccount = 0;
            while (progresses[i] < 100) {

                progresses[i] += speeds[i];
                ccount++;
            }
            time[i] = ccount;
            task.offer(time[i]);
        }


        int release = 1;
        int current = task.poll();

        while (!task.isEmpty()) {
            int next = task.poll();

            if (current >= next) {
                release++;
            } else {
                answer.add(release);
                release = 1;
                current = next;

            }


        }

        answer.add(release);

        return answer;
    }


    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
//        int[] progresses = {95, 90, 99, 99, 80, 99};

        int[] speeds = {1, 30, 5};
//        int[] speeds = {1, 1, 1, 1, 1, 1};

        FunctionDevelopment_ffbear sol = new FunctionDevelopment_ffbear();
        sol.solution(progresses, speeds);

    }


}
