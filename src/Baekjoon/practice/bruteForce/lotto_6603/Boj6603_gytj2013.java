package Baekjoon.practice.bruteForce.lotto_6603;
import java.util.*;

class Boj6603_gytj2013 {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String s;
    	int n=0;
    	
    	while(scan.hasNextLine()) {
    		s = scan.nextLine();
    		String[] tmp = s.split(" ");
    		n = Integer.parseInt(tmp[0]);
    		boolean[] visited = new boolean[n];
    		int[] arr = new int[n];
    		for(int i=0; i<n; i++) {
    			arr[i] = Integer.parseInt(tmp[i+1]);
    		}
    		comb(arr, visited, 0, n, 6);
    		 System.out.println();
    	}
    }

	private static void comb(int[] arr, boolean[] visited, int idx, int n, int r) {
		if(r==0) {
			for (int i = 0; i < n; i++) {
	            if (visited[i]) {
	                System.out.print(arr[i] + " ");
	            }
	        }
	        System.out.println();
			return;
		}
		for(int i = idx; i<n; i++) {
			visited[i] = true;
			comb(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
}