package programmers.level02.friendsBlock;

public class FriendsBlock_ffbear {

    static String[][] block;

    public int solution(int m, int n, String[] board) {

        block = new String[board.length][];

        for (int i = 0; i < board.length; i++) {
            block[i] = board[i].split("");
        }

        int answer = 0;

        while (true) {
            int cnt = check(m, n);
            if (cnt == 0) {
                break;
            }
            answer += cnt;
            dropBlock(m, n);
        }

        System.out.println(answer);
        return answer;
    }

    static int check(int m, int n) {

        boolean[][] squareChk = new boolean[m][n];

        for (int i = 1; i < m; i++) {
            boolean isSquare = false;
            for (int j = 1; j < n; j++) {

                if (!block[i][j].equals(" ")) {
                    String current = block[i][j];

                    if (block[i - 1][j - 1].equals(current) && block[i - 1][j].equals(current) && block[i][j - 1].equals(current)) {

                        squareChk[i - 1][j - 1] = true;
                        squareChk[i][j - 1] = true;
                        squareChk[i - 1][j] = true;
                        squareChk[i][j] = true;

                    }
                }
            }
        }
        return countSquare(m, n, squareChk);
    }

    static int countSquare(int m, int n, boolean[][] sqareChk) {

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sqareChk[i][j]) {
                    count++;
                    block[i][j] = " ";
                }

            }
        }

        return count;
    }

    static void dropBlock(int m, int n) {

        for (int i = m - 1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (block[i][j].equals(" ")) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (!block[k][j].equals(" ")) {
                            block[i][j] = block[k][j];
                            block[k][j] = " ";
                            break;

                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        FriendsBlock_ffbear sol = new FriendsBlock_ffbear();
        sol.solution(m, n, board);


    }


}
