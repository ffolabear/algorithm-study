package Baekjoon.practice.simulation.treeInvestmentTech_16235;

import java.util.*;

class tree{
	int x, y, age;
	tree(int x, int y, int age){
		this.x=x;
		this.y=y;
		this.age=age;
	}
}

class Boj16235_gytj2013{
	static int N, M, K;
	static int[][] A, food;
	static Deque<tree> treeArr = new ArrayDeque<>();
	static Deque<tree> dead = new ArrayDeque<>();
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	M = scan.nextInt();
    	K = scan.nextInt();
    	A = new int[N+1][N+1];
    	food = new int[N+1][N+1];
    	
    	for(int i=1; i<N+1; i++) {
    		for(int j=1; j<N+1; j++) {
    			A[i][j] = scan.nextInt();
    			food[i][j] = 5;
    		}
    	}
    
    	for(int i=0; i<M; i++) {
    		int x = scan.nextInt();
    		int y = scan.nextInt();
    		int z = scan.nextInt();
    		treeArr.add(new tree(x,y,z));
    	}
    	
    	for(int i=0; i<K; i++) {
	    	spring();
	    	summer();
	    	fall();
	    	winter();
    	}
    	
    	System.out.println(treeArr.size());
	}
	private static void spring() {
		int len = treeArr.size();
		for(int i=0; i<len; i++) {
			tree tmp = treeArr.poll();
			int x = tmp.x;
			int y = tmp.y;
			int age = tmp.age;
			
			if(age<=food[x][y]) {
				food[x][y]-=age;
				treeArr.add(new tree(x, y, age+1));
			}else {
				dead.add(new tree(x, y, age/2));
			}
		}
	}
	private static void summer() {
		while(!dead.isEmpty()) {
			tree tmp = dead.poll();
			food[tmp.x][tmp.y] += tmp.age;
		}
	}
	private static void fall() {
		Deque<tree> temptree = new ArrayDeque<tree>();
		int len = treeArr.size();
		for(int i=0; i<len; i++) {
			tree tmp = treeArr.poll();
			int x = tmp.x;
			int y = tmp.y;
			int age = tmp.age;
			
			if(age%5==0) {
				for(int idx=0; idx<8; idx++) {
					if(x+dx[idx]>0 & y+dy[idx]>0 & x+dx[idx]<=N & y+dy[idx]<=N) {
						temptree.addFirst(new tree(x+dx[idx], y+dy[idx], 1));
					}
				}
			}
			temptree.add(new tree(x, y, age));
		}
		treeArr = temptree;
	}
	private static void winter() {
		for(int i=1; i<N+1; i++) {
    		for(int j=1; j<N+1; j++) {
    			food[i][j]+=A[i][j];
    		}
		}
		
	}
}