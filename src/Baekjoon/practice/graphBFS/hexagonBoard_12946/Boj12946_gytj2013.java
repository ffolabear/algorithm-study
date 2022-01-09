package Baekjoon.practice.graphBFS.hexagonBoard_12946;
import java.io.*;
import java.util.Arrays;

class Boj12946_gytj2013{
	static int N, ans;
	static String[][] board; // 육각 보드 정보 담은 배열 
	static int[][] col; //칸의 색 정보 
	static int[] dx = {-1, -1, 0, 1, 1, 0}; // 변을 공유하는 6개의 칸 인덱스 
	static int[] dy = {0, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	board = new String[N][N];
    	col = new int[N][N];
    	
    	for(int i=0; i<N; i++) {
    		board[i] = br.readLine().split("");
    	}
    	
    	for (int i = 0; i < N; i++) {
			Arrays.fill(col[i], -1); // 칸의 색 정보를 -1로 초기화 
		}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(board[i][j].equals("X") & col[i][j]==-1) { // 색칠해야 하는 칸이 색칠이 안 되어 있으 
    				color(i, j, 0); // 0번으로 색칠 
    			}
    		}
    	}
    	System.out.println(ans);
	}

	private static void color(int x, int y, int c) {
		col[x][y] = c; // c 색으로 색칠 
		if(ans==0) {ans=1;} //색을 칠해야 하는 칸이 있으니까 최소 1  
		for(int idx=0; idx<6; idx++) { // 인접한 6개의 칸마다 
			int nx = x+dx[idx];
			int ny = y+dy[idx];
			
			if(nx>=0 & nx<N & ny>=0 & ny<N) { // 범위 안에 들어오면 
				if(board[nx][ny].equals("X")) { // 인접 칸이 색칠해야 하는 칸이 
					if(col[nx][ny]==-1) { // 인접 칸이 아직 색칠 전이면  
						color(nx, ny, 1-c); // 1-c 색으로 색칠 
					}
					if(ans<2) {ans=2;} // 최소 인접한 두 칸이 색칠되어야 하니까 최소 2  
					if(col[nx][ny] == c) { // 이미 방문했는데 색이 같다면
						if(ans<3) {ans=3;} // 최소 3가지 색 필요  
					}
				}
			}
		}
	}

}