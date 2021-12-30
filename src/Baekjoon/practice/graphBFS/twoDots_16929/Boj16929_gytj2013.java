package Baekjoon.practice.graphBFS.twoDots_16929;
import java.util.Scanner;

class Boj16929_gytj2013 {
	static int N, M;
	static String[][] arr;
	static Boolean[][] visited;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static Boolean chk= false;
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String s = scan.nextLine();
    	String tmp[] = s.split(" ");
    	N = Integer.parseInt(tmp[0]);
    	M = Integer.parseInt(tmp[1]);
    	
    	arr = new String[N][M];
    	
    	for(int i=0; i<N; i++) {
    		s = scan.nextLine();
    		arr[i] = s.split("");
    	}
    	
    	visited = new Boolean[N][M];

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = false;
			}
		}
    	
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {
					cycle(i, j, -1, -1, 1);
				}
			}
		}
		System.out.println(chk ? "Yes":"No");
    }

	private static void cycle(int y, int x, int bY, int bX, int cnt) {
		if(visited[y][x] && cnt>=4) {
			chk =true;
			return;
		}
		
		visited[y][x] = true;
		
		for(int k=0; k<4; k++) {
			int nY = y + dy[k];
			int nX = x + dx[k];
			
			if (!(0 <= nY && nY < N && 0 <= nX && nX < M)) continue;
			if (!arr[y][x].equals(arr[nY][nX])) continue;
			if(nY == bY && nX == bX) continue;
			
			cycle(nY, nX, y, x, cnt+1);
		}
	}
}