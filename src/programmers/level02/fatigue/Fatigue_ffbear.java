package programmers.level02.fatigue;

public class Fatigue_ffbear {

    static int user = 0;

    public int solution(int k, int[][] dungeons) {


        boolean[] visited = new boolean[dungeons.length];
        expedition(k, visited, dungeons, 0);


        System.out.println(user);
        return user;
    }

    static void expedition(int k, boolean[] visited, int[][] dungeons, int count) {

        if (count >= visited.length) {
            user = count;
            return;
        }


        for (int i = 0; i < dungeons.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (k < dungeons[i][0]) {
                user = Math.max(user, count);
                continue;
            }

            visited[i] = true;
            expedition(k - dungeons[i][1], visited, dungeons, count+1);
            visited[i] = false;

        }

        return;

    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        Fatigue_ffbear sol = new Fatigue_ffbear();
        sol.solution(k, dungeons);

    }
}
