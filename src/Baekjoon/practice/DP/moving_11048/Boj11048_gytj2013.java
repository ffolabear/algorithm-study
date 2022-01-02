package Baekjoon.practice.DP.moving_11048;
import java.util.Scanner;

class Boj11048_gytj2013 {
	static int N, M;
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	N = scan.nextInt();
    	M = scan.nextInt();
    	
    	int[][] arr = new int[N][M];
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			arr[i][j] = scan.nextInt();
    		}
    	}
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<M; j++) {
    			if(i==0 & j==0) { continue;}
    			if(i==0) {
    				arr[i][j] += arr[i][j-1];
    			}
    			else if(j==0) {
    				arr[i][j] += arr[i-1][j];
    			}
    			else {
    				arr[i][j] += Math.max(arr[i][j-1], arr[i-1][j]);
    			}
    		}
    	}
    	
    	System.out.print(arr[N-1][M-1]);
    	
    }
}