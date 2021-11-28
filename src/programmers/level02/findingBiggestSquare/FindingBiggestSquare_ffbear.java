package programmers.level02.findingBiggestSquare;

public class FindingBiggestSquare_ffbear {

    public int solution(int[][] board) {

        int max = 0;

        int[][] newBoard = newBoard = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }


        for (int i = 1; i < newBoard.length; i++) {
            for (int j = 1; j < newBoard[i].length; j++) {
                if (newBoard[i][j] == 1) {

                    int left = newBoard[i - 1][j];
                    int up = newBoard[i][j - 1];
                    int leftUp = newBoard[i - 1][j - 1];

                    //각 꼭지점의 값 체크했을때 꼭짓점이 0인경우가 있을수있음
                    int min = Math.min(left, Math.min(up, leftUp));

                    //꼭짓점이 0이면 정사각형이 아니므로 1로 초기화
                    //0이 아니라면 길이가 1...2...3 식으로 바꿔서 저장
                    newBoard[i][j] = min + 1;
                    max = Math.max(max, min + 1);

                }
            }
        }

        int answer = max * max;
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {

        int[][] board = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}};

        FindingBiggestSquare_ffbear sol = new FindingBiggestSquare_ffbear();
        sol.solution(board);

    }
}
