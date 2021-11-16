package programmers.level02.lifeboat;

import java.util.Arrays;

public class Lifeboat_ffbear {

    public int solution(int[] people, int limit) {

        int answer = 0;

        Arrays.sort(people);

        for (int i : people) {
            System.out.println(i);
        }

        int min = 0;
        int max = people.length - 1;

        for (int i = people.length - 1; i >= min ; i--) {
            if (people[i] + people[min] <= limit) {
                min++;
                answer++;
            } else {
                answer++;
            }
        }

        System.out.println(answer);


        return answer;
    }

    public static void main(String[] args) {

        int[] people = {70, 50, 80, 50};
        int limit = 100;

        Lifeboat_ffbear sol = new Lifeboat_ffbear();
        sol.solution(people, limit);

    }
}
