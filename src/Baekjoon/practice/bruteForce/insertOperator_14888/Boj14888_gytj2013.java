package Baekjoon.practice.bruteForce.insertOperator_14888;

import java.io.*;
import java.util.*;

class Boj14888_gytj2013{
	static int N;
	static int max = -1000000000;
	static int min = 1000000000;
	static int[] nums, operator;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		operator = new int[N-1];
		visited = new boolean[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for(int j = 0 ; j < 4; j++) {
        	int cnt = Integer.parseInt(st.nextToken());
	        for(int i = 0 ; i < cnt; i++) {
	        	operator[i+idx] = j;
	        }
	        idx+=cnt;
        }
        
        calc(nums[0], 0);
        
        System.out.println(max);
        System.out.println(min);
        
	}
	
	private static void calc(int sum, int cnt) {
		if(cnt==N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for(int i = 0 ; i < N-1; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			if(operator[i]==0) {
				calc(sum + nums[cnt+1], cnt+1);
			}else if(operator[i]==1) {
				calc(sum - nums[cnt+1], cnt+1);
			}else if(operator[i]==2) {
				calc(sum * nums[cnt+1], cnt+1);
			}else{
				calc(sum / nums[cnt+1], cnt+1);
			}
			visited[i] = false;
		}
	}
}