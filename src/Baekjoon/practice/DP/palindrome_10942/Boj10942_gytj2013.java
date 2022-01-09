package Baekjoon.practice.DP.palindrome_10942;
import java.io.*;
import java.util.*;

class Boj10942_gytj2013{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(br.readLine());
    	boolean[][] dp = new boolean[N+1][N+1];
    	for(int i=0; i<N; i++) {
    		dp[i+1][i+1] = true;
    	}
    	for(int i=0; i<N-1; i++) {
    		if(nums[i]==nums[i+1]) {
    			dp[i+1][i+2] = true;
    		}
    	}
    	for(int i=2; i<N; i++) {
    		for(int j=0; j<N-i; j++) {
    			if(nums[j]==nums[j+i] & dp[j+2][j+i]) {
        			dp[j+1][j+i+1] = true;
        		}
    		}
    	}
    	StringBuilder answer = new StringBuilder();
    	for(int i=0; i<M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int S = Integer.parseInt(st.nextToken());
    		int E = Integer.parseInt(st.nextToken());
    		if(dp[S][E]) {
    			answer.append("1\n");
    		}else {
    			answer.append("0\n");
    		}
    	}
    	System.out.println(answer);
	}
}