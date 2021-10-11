package programmers.level02.rotatingMatrixBorder;

public class rotatingMatrixBorder_jola7373 {
    class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            int matrix[][] = new int[rows][columns];
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    matrix[i][j] = i*columns + j + 1;
                }
            }
            for(int i=0; i <queries.length; i++ ){
                answer[i] = rotation(queries, matrix,i);
            }

            return answer;
        }

        public int rotation(int [][] queries, int [][]matrix,int num){
            int smallest = matrix.length* matrix.length;
            for(int x1= queries[num][0];x1 < queries[num][2]; x1++ ){
                if(smallest > matrix[1][x1]){
                    smallest = matrix[1][x1];
                }
                if(smallest > matrix[3][x1]){
                    smallest = matrix[3][x1];
                }
            }
            for(int y1= queries[num][1]; y1 < queries[num][3]; y1++ ){
                if(smallest > matrix[y1][0]){
                    smallest = matrix[y1][0];
                }
                if(smallest > matrix[y1][2]){
                    smallest = matrix[y1][2];
                }
            }
            return smallest;
        }
    }
}
