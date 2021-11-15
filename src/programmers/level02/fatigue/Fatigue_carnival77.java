package programmers.level02.fatigue;

public class Fatigue_carnival77 {
    static int answer=0;
    static int n=0;
    static boolean[] used;

    public int solution(int k, int[][] dungeons) {

        n=dungeons.length;
        used=new boolean[n];

        dfs(0,k,dungeons);

        return answer;
    }

    public void dfs(int cnt, int k, int[][] d) {
        if (cnt > n)
            return;

        answer = Math.max(cnt, answer);

        for (int i = 0; i < n; i++) {
            if (!used[i] && d[i][0] <= k) {
                used[i] = true;
                dfs(cnt + 1, k - d[i][1], d);
                used[i] = false;
            }
        }
    }
}
