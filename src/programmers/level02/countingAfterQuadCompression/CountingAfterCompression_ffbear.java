package programmers.level02.countingAfterQuadCompression;

public class CountingAfterCompression_ffbear {

    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {

        int length = arr.length;

        compression(0, 0, length, arr);


        return answer;
    }

    static void compression(int x, int y, int length, int[][] arr) {

        if (length == 1) {
            answer[arr[x][y]]++;
            return;
        }

        if (blockChk(x, y, length,arr)) {
            return;
        }

        compression(x, y, length / 2, arr);
        compression(x + length / 2, y, length / 2, arr);
        compression(x, y + length / 2, length / 2, arr);
        compression(x + length / 2, y + length / 2, length / 2, arr);

    }

    static boolean blockChk(int x, int y, int length, int[][] arr) {
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (arr[x][y] != arr[i][j]) {
                    return false;
                }
            }
        }

        answer[arr[x][y]]++;
        return true;
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 1, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 1, 1, 1}};

        CountingAfterCompression_ffbear sol = new CountingAfterCompression_ffbear();
        sol.solution(arr);

    }
}
