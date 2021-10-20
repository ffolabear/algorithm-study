package programmers.level02.distanceCheck;

public class DistanceCheck_ffbear {


    static int[] d1x = {0, 0, 1, -1};
    static int[] d1y = {1, -1, 0, 0};

    static int[] d2x = {0, 0, 2, -2};
    static int[] d2y = {2, -2, 0, 0};

    static int[] gx = {1, 1, -1, -1};
    static int[] gy = {1, -1, 1, -1};

    public int[] solution(String[][] places) {

        int[] answer = new int[places.length];


        for (int i = 0; i < places.length; i++) {

            String[] row = places[i];
            boolean flag = false;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (row[j].charAt(k) == 'P') {
                        if (check(j, k, row)){
                            flag = true;
                            break;
                        }
                    }
                }
                if (flag){
                    answer[i] = 0;
                    break;
                }

            }
            if (!flag) {
                answer[i] = 1;
            }

        }

        return answer;
    }

    static boolean check(int x, int y, String[] row) {

        //상하좌우 P 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + d1x[i];
            int ny = y + d1y[i];

            if (nx >= 5 || ny >= 5 || nx < 0 || ny < 0) {
                continue;
            }

            if (row[nx].charAt(ny) == 'P') {
                return true;
            }

        }

        // 거리2인 상하좌우 P 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + d2x[i];
            int ny = y + d2y[i];

            if (nx >= 5 || ny >= 5 || nx < 0 || ny < 0) {
                continue;
            }

            if (row[nx].charAt(ny) == 'P') {
                if (row[(nx + x) / 2].charAt((ny + y) / 2) != 'X') {
                    return true;

                }

            }

        }

        //대각선 P 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + gx[i];
            int ny = y + gy[i];

            if (nx >= 5 || ny >= 5 || nx < 0 || ny < 0) {
                continue;
            }

            if (row[nx].charAt(ny) == 'P') {
                if (!(row[x].charAt(ny) == 'X' && row[nx].charAt(y) == 'X')) {
                    return true;

                }

            }

        }

        return false;
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
