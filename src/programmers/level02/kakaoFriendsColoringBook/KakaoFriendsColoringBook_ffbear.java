package programmers.level02.kakaoFriendsColoringBook;

public class KakaoFriendsColoringBook_ffbear {

    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;

    //현재 탐색하는 영역의 크기
    static int temp_cnt = 0;

    //상하좌우 좌표 탐색용 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {

        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];


        boolean[][] visted = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visted[i][j]) {
                    numberOfArea++;
                    dfs(i, j, picture, visted);

                }

                if (temp_cnt > maxSizeOfOneArea) {
                    maxSizeOfOneArea = temp_cnt;
                }
                temp_cnt = 0;

            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    static void dfs(int x, int y, int[][] picture, boolean[][] visited) {

        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        temp_cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > picture.length || ny < 0 || ny > picture[0].length) {
                continue;

            }

            if (picture[x][y] == picture[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny, picture, visited);
            }

        }


    }

    public static void main(String[] args) {

        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};

        KakaoFriendsColoringBook_ffbear sol = new KakaoFriendsColoringBook_ffbear();
        sol.solution(m, n, picture);

    }


}
