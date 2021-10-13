package programmers.level02.targetnum;

public class TargetNumber_jola7373 {
    class Solution {
        public int answer = 0;
        public int solution(int[] numbers, int target) {
            dfs(numbers, target, 0, 0);
            return answer;
        }
        public void dfs(int[] numbers, int target, int prev, int idx){
            if((target==prev) && (idx >= numbers.length)){
                answer++;
                return;
            }
            if(idx >= numbers.length){
                return;
            }
            dfs(numbers, target,prev+numbers[idx],idx+1);
            dfs(numbers, target,prev-numbers[idx],idx+1);
        }
    }

}
