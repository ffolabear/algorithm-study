package Baekjoon.practice.bruteForce.sumOfPartialSequence_14225;

import java.io.*;
import java.util.*;

class Boj14225_gytj2013{
	static int N;
	static int[] arr;
	static boolean[] found;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	arr = new int[N];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int sum = Arrays.stream(arr).sum();
    	int answer = sum+1;
    	
    	found = new boolean[sum+1];
    	
    	for(int i=0; i<N; i++) {
    		find(i, arr[i]);
    	}
    	
    	for(int i=1; i<sum; i++) {
    		if(!found[i]) {
    			answer = i;
    			break;
    		}
    	}
    	
    	System.out.print(answer);
    	
	}

	private static void find(int idx, int num) {
		found[num] = true;
		for(int i=idx+1; i<N; i++) {
			System.out.println(num+arr[i]);
    		find(i, num+arr[i]);
    	}
	}
}