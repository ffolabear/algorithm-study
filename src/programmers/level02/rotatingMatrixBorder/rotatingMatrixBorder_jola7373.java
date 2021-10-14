package programmers.level02.rotatingMatrixBorder;

public class rotatingMatrixBorder_jola7373 {

    class Solution {
        int matrix[][];
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            this.matrix = new int[rows][columns];
            //매트릭스를 생성해준다.
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    this.matrix[i][j] = i*columns + j + 1;
                }
            }


            for(int i=0; i <queries.length; i++ ){
                answer[i] = rotation(queries,i);
            }

            return answer;
        }

        public int rotation(int [][] queries,int num){
            int r1 = queries[num][0]-1;
            int c1 = queries[num][1]-1;
            int r2 = queries[num][2]-1;
            int c2 = queries[num][3]-1;
            int temp = matrix[r1][c1];
            int smallest = temp;
            //첫번째 rotation에 맨 위엣줄 부터
            for(int i= r1;i < r2; i++){//x1에서 x2부분까지의 숫자들 rotation진행
                this.matrix[i][c1] = this.matrix[i+1][c1];
                if(smallest > this.matrix[i][c1]){
                    smallest = this.matrix[i][c1];
                }
            }
            for(int i= c1;i < c2; i++){
                this.matrix[r2][i] = this.matrix[r2][i+1];
                if(smallest > this.matrix[r2][i]){
                    smallest = this.matrix[r2][i];
                }
            }
            for(int i = r2; i > r1; i--){
                this.matrix[i][c2] = this.matrix[i-1][c2];
                if(smallest > this.matrix[i][c2]){
                    smallest = this.matrix[i][c2];
                }
            }
            for(int i = c2; i > c1; i--){
                this.matrix[r1][i] = this.matrix[r1][i-1];
                if(smallest > this.matrix[r1][i]){
                    smallest = this.matrix[r1][i];
                }
            }
            this.matrix[r1][c1+1] = temp;
            return smallest;
        }
    }
}
