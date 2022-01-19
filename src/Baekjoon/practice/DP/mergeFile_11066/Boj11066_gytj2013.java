package Baekjoon.practice.DP.mergeFile_11066;

import java.io.*;
import java.util.*;

class Boj11066_gytj2013{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<T; i++) {
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] sum = new int[K+1];
			for(int j=1; j<=K; j++) {
				sum[j] = sum[j-1]+Integer.parseInt(st.nextToken());
			}
			System.out.println(minCost(sum, K));
		}
		
	}

	private static int minCost(int[] sum, int K) {
		int[][] dp = new int[K][K];
		for(int i=1; i<K; i++) {
			for(int x=0; x<K-i; x++) {
				int y = x+i;
				dp[x][y] = 2000000000;
				
				for(int m = x; m<y; m++) {
					dp[x][y] = Math.min(dp[x][y], dp[x][m]+dp[m+1][y]+sum[y+1]-sum[x]);
				}
			}
		}
		return dp[0][K-1];
	}
}