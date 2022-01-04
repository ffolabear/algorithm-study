package Baekjoon.practice.DP.jumpJump_11060;

import java.util.Scanner;

class Boj11060_gytj2013{ 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    	int N = scan.nextInt();
    	int[] arr = new int[N];
    	int answer=0;
    	
    	for(int i=0; i<N; i++) {
    		arr[i] = scan.nextInt();
    	}
    	
    	int target = N-1;
    	boolean check;
    	
    	while(true) {
    		if(target==0) { break; }
    		check = false;
    		for(int i=0; i<target; i++) {
    			if(i+arr[i] >= target) {
    				target = i;
    				answer++;
    				check=true;
    			}
    		}
    		if(check) {continue;}
    		answer = -1;
    		break;
    	}
    	
    	System.out.print(answer);
    	
	}
}