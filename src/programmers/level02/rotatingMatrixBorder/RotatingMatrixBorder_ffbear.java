package programmers.level02.rotatingMatrixBorder;

public class RotatingMatrixBorder_ffbear {

    static int[][] matrix;


    public int[] solution(int rows, int columns, int[][] queries) {

        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows + 1][columns + 1];


        int start = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = start++;
            }
        }


        for (int i = 0; i < queries.length; i++) {

//            answer[i] = rotating(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
            answer[i] = rotating(queries[i][0], queries[i][1], queries[i][2], queries[i][3], matrix);
        }


        return answer;
    }


    static int rotating(int x1, int y1, int x2, int y2, int[][] matrix) {


        int temp = matrix[x1][y1];
        int min = temp;

        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            min = Math.min(min, matrix[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            matrix[x2][i] = matrix[x2][i + 1];
            min = Math.min(min, matrix[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];

            min = Math.min(min, matrix[i][y2]);
        }

        for (int i = y2; i > y1; i--) {
            matrix[x1][i] = matrix[x1][i - 1];
            min = Math.min(min, matrix[x1][i]);
        }

        matrix[x1][y1 + 1] = temp;
        System.out.println(min);

        return min;
    }


    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        RotatingMatrixBorder_ffbear sol = new RotatingMatrixBorder_ffbear();
        sol.solution(rows, columns, queries);


    }
}
