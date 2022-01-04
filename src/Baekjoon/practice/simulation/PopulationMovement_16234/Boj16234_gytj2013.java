package Baekjoon.practice.simulation.PopulationMovement_16234;

import java.util.*;

class Boj16234_gytj2013{
	static int N, L, R;
	static int[][] arr;
	static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    
	public static void main(String[] args) {
		int answer = 0;
		Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	L = scan.nextInt();
    	R = scan.nextInt();
    	
    	arr = new int[N][N];
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			arr[i][j] = scan.nextInt();
    		}
    	}
    	
    	while(true) {
    		boolean move = false;
    		visited = new boolean[N][N];
    		for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			if(visited[i][j]) {continue;}
        			if(bfs(N*i+j)) {move=true;}
        		}
    		}
    		if(!move) {break;}
    		answer++;
    	}
    	
    	System.out.print(answer);
	}

	private static boolean bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
    	q.add(idx);
    	list.add(idx);
    	visited[idx/N][idx%N] = true;
    	
    	int total = arr[idx/N][idx%N];
    	int chk;
    	int p,x,y;
    	
    	while(!q.isEmpty()) {
    		p = q.poll();
    		x = p/N;
    		y = p%N;
    		
    		for(int i=0; i<4; i++) {
    			int nx = x + dx[i];
    			int ny = y + dy[i];
    			if(nx >= 0 & ny >=0 & nx < N & ny < N ) {
    				if(visited[nx][ny]) {continue;}
    				chk = Math.abs(arr[x][y]-arr[nx][ny]);
    				if(chk >= L & chk <= R) {
    					q.add(N*nx+ny);
    					list.add(N*nx+ny);
    					visited[nx][ny] = true;
    					total += arr[nx][ny];
    				}
    			}
    		}
    	}
    	
    	if(list.size()>1) {
    		total /= list.size();
    		for(int a : list) {
    			arr[a/N][a%N] = total; 
    		}
    		return true;
    	}else {
    		return false;
    	}
	}
}