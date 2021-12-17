package programmers.level03.farthestNode;


import java.util.*;

class FarthestNode_gytj2013 {
    public static int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] node1 = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] v : edge) {
        	graph.get(v[0]).add(v[1]);
        	graph.get(v[1]).add(v[0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        
        while(!q.isEmpty()) {
        	int node = q.poll();
        	for(int v : graph.get(node)) {
        		if(!visited[v]) {
        			node1[v] = node1[node]+1;
        			 visited[v]=true;
        			 q.add(v);
        		}
        	}
        }
     
        Arrays.sort(node1);
        int max = node1[n];
        int idx=0;
        for(idx=n-1; idx>0; idx--) {
        	if(node1[idx]!=max) {break;}
        }
       
        return n-idx;
    }
}