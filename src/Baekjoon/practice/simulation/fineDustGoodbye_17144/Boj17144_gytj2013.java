package Baekjoon.practice.simulation.fineDustGoodbye_17144;
import java.io.*;
import java.util.*;

class Boj17144_gytj2013{
	static int R, C, T;
	static int cleaner;
	static int sum = 0;
	static int[][] room;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        room = new int[R][C];
        
        for(int i=0; i<R; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<C; j++) {
        		room[i][j] = Integer.parseInt(st.nextToken());
        		if(room[i][j]==-1) {cleaner = i;}
        		else { sum += room[i][j]; }
        	}
        }
        
        for(int i=0; i<T; i++) {
	        diffusion();
	        //System.out.println(Arrays.deepToString(room));
	        airCleaner();
	        //System.out.println(Arrays.deepToString(room));
        }
        System.out.println(sum);
	}
	private static void diffusion() {
		int[][] tmp = new int[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++){
				int amount = room[i][j];
				if(amount==0) {continue;}
				if(amount==-1) {
					tmp[i][j] = -1;
					continue;
				}
				int cnt = 0;
				for(int idx=0; idx<4; idx++) {
					int x = i+dx[idx];
					int y = j+dy[idx];
					if(x>=0 & x<R & y>=0 & y<C) {
						if(room[x][y]!=-1) {
							tmp[x][y] += amount/5;
							cnt++;
						}
					}
				}
				tmp[i][j] += amount - ((amount/5)*cnt);
			}
		}
		room=tmp;
	}
	private static void airCleaner() {
		sum -= room[cleaner-2][0];
		for(int i=cleaner-2; i>0; i--) {
			room[i][0] = room[i-1][0];
		}
		for(int i=0; i<C-1; i++) {
			room[0][i] = room[0][i+1];
		}
		for(int i=0; i<cleaner-1; i++){
			room[i][C-1] = room[i+1][C-1];
		}
		for(int i=C-2; i>0; i--) {
			room[cleaner-1][i+1] = room[cleaner-1][i];
		}
		room[cleaner-1][1] = 0;
		
		sum -= room[cleaner+1][0];
		for(int i=cleaner+1; i<R-1; i++){
			room[i][0] = room[i+1][0];
		}
		for(int i=0; i<C-1; i++) {
			room[R-1][i] = room[R-1][i+1];
		}
		for(int i=R-2; i>=cleaner; i--){
			room[i+1][C-1] = room[i][C-1];
		}
		for(int i=C-2; i>0; i--) {
			room[cleaner][i+1] = room[cleaner][i];
		}
		room[cleaner][1] = 0;
	}
}