package programmers.level02.matrixMultiplication;

class MatrixMultiplication_gytj2013 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int n = arr2.length;
        int[][] answer = new int[row][col];
        
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		for(int x=0; x<n; x++) {
        			answer[i][j] += arr1[i][x] * arr2[x][j];
        		}
        	}
        }
 
        return answer;
    }
}