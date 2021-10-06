package programmers.level02.targetnum;

public class TargetNum_ffbear {

    static int answer;


    public int solution(int[] numbers, int target) {

        answer = 0;
        dfs(numbers, target, 0, 0);

        System.out.println(answer);
        return answer;
    }

    static void dfs(int[] numbers, int target, int idx, int sum) {

        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;

        }

        //더하는 경우 탐색
        sum += numbers[idx];
        dfs(numbers, target, idx + 1, sum);

        sum -= numbers[idx];

        //빼는 경우 탐색
        sum += numbers[idx] * (-1);
        dfs(numbers, target, idx + 1, sum);


    }

    public static void main(String[] args) {

        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        TargetNum_ffbear sol = new TargetNum_ffbear();
        sol.solution(numbers, target);

    }
}
