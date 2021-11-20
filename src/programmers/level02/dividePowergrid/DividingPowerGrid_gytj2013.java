package programmers.level02.dividePowergrid;

import java.util.*;

class DividingPowerGrid_gytj2013{
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static Set<Integer> setA;
    
	public static int solution(int n, int[][] wires) {
    	 for (int i = 0; i <= n; i++) {
             graph.add(new ArrayList<>());
         }
    	 
    	 for (int i = 0; i < n-1; i++) {
             graph.get(wires[i][0]).add(wires[i][1]);
             graph.get(wires[i][1]).add(wires[i][0]);
         }
    	
    	 int answer = n;
    	 int a, b;
    	 for (int i = 0; i < n-1; i++) {
    		 setA = new HashSet<>();
    		 a = wires[i][0];
    		 b = wires[i][1];
    		 setA.add(a);
    		 for(int j=0; j<graph.get(a).size(); j++) {
    			 int tmp = graph.get(a).get(j);
    			 if(tmp==b) {continue;}
    			 setA.add(tmp);
    			 recursive(tmp);
    		 }
    		 answer = Math.min(answer,Math.abs(n-2*setA.size()));
    	 }

        return answer;
    }
    private static void recursive(int a) {
    	if(graph.get(a).size()==1) {return;}
		for(int i=0; i<graph.get(a).size(); i++) {
			int tmp =graph.get(a).get(i);
			if(setA.contains(tmp)) {continue;}
			setA.add(tmp);
			recursive(tmp);
		}
	}
}