package Baekjoon.practice.bruteForce.sumOfPartialSequence_1182;

import java.util.Scanner;

class Boj1182_gytj2013{
	static int N, S;
	static int[] num;
	static int answer = 0;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	S = scan.nextInt();
    	num = new int[N];
    	
    	for(int i=0; i<N; i++) {
    		num[i] = scan.nextInt();
    	}
    	
    	for(int r=1; r<=N; r++) {
    		comb(0, r, 0);
    	}
    	
    	System.out.println(answer);
	}
	private static void comb(int start, int r, int sum) {
		if(r==0) {
			if(S==sum) {answer++;}
			return;
		} else {
			for(int i=start; i<N; i++) {
				comb(i+1, r-1, sum+num[i]);
			}
		}
		
	}
}