package Baekjoon.practice.graphBFS.seoulSubwayLine2_16947;
import java.util.*;

class Boj16947_gytj2013{
	static int N;
	static ArrayList<Integer> graph[];
	static boolean visited[];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	graph = new ArrayList[N+1];
    	int[] answer = new int[N];
    	Queue<Integer> q = new LinkedList<>();
    	
    	for(int i=1; i<N+1; i++) {
    		graph[i] = new ArrayList<>();
    	}
    	for(int i=0; i<N; i++) {
    		int u = scan.nextInt();
    		int v = scan.nextInt();
    		graph[u].add(v);
    		graph[v].add(u);
    		answer[i] = N+1;
    	}
    	for(int i=1; i<N+1; i++) {
    		visited = new boolean[N+1];
    		if(answer[i-1]==0) {continue;}
    		if(isCycle(i, i, -1)) {
    			for(int j=1; j<N+1; j++) {
    				if(visited[j]) {
    					answer[j-1] = 0;
    					q.add(j);
    				}
    			}
    		}
    	}
    	
    	visited = new boolean[N+1];
    	
    	while(!q.isEmpty()) {
    		int n = q.poll();
    		visited[n]=true;
    		for(int node : graph[n]) {
    			if(visited[node]) {continue;}
    			answer[node-1] = Math.min(answer[node-1], answer[n-1]+1);
    			if(!q.contains(node)) {q.add(node);}
    		}
    	}
    	
    	for(int ans : answer) {
    		System.out.print(ans+" ");
    	}
    	
	}

	private static boolean isCycle(int idx, int cur, int par) {
		visited[cur] = true;
		for(int node : graph[cur]) {
			if(!visited[node]) {
				if(isCycle(idx, node, cur)) {
					return true;
				} else {
					visited[node] = false;
				}
			} else if(node == idx & node != par) {
				return true;
			} 
		}
		return false;
	}
}