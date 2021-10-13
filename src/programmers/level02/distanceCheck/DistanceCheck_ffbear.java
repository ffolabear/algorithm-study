package programmers.level02.distanceCheck;

public class DistanceCheck_ffbear {


    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {

        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < places.length; i++) {

            boolean valid = true;
            for (int j = 0; j < places[i].length; j++) {

                if (places[i][j].equals("P")) {
                    check(i, j, places, visited);

                }

            }

        }

        int[] answer = {};
        return answer;
    }

    static void check(int x, int y, String[][] places, boolean[][] visited) {

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int ni = i + dx[i];
            int ny = i + dy[i];


        }

    }



    public static void main(String[] args) {

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        DistanceCheck_ffbear sol = new DistanceCheck_ffbear();
        sol.solution(places);


    }
}
