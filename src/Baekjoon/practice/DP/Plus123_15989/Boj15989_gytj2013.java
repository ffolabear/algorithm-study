package Baekjoon.practice.DP.Plus123_15989;

import java.io.*;

class Boj15989_gytj2013{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		int max=0;
		for(int i=0; i<T; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max=Math.max(max, arr[i]);
		}
		int[] answer = new int[max+1];
		
		answer[1]=1;
		answer[2]=2;
		answer[3]=3;
		
		for(int i=4; i<max+1; i++) {
			answer[i]=answer[i-1]+answer[i-2]-answer[i-3];
			if((i-3)%3==0) {answer[i]++;}
		}
		for(int t: arr) {
			System.out.println(answer[t]);
		}
	}

}