package Baekjoon.practice.bruteForce.insertOperator_15658;
import java.io.*;
import java.util.*;

class Boj15658_gytj2013{
	static int N;
	static int plus, minus, multi, div;
	static int max = -1000000000;
	static int min = 1000000000;
	static int[] nums;
	static int[] operator = new int[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<4; i++) {
        	operator[i] = Integer.parseInt(st.nextToken());
        }
        
        calc(nums[0], 0, operator[0]+operator[1]+operator[2]+operator[3]);
        
        System.out.println(max);
        System.out.println(min);
        
	}
	
	private static void calc(int sum, int cnt, int n) {
		 //System.out.println(sum);
		if(cnt==N-1) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for(int j=0; j<4; j++) {
			if(operator[j]==0) {continue;}
			operator[j]--;
			switch(j) {
				case 0 :
					calc(sum + nums[cnt+1], cnt+1, n);
					break;
				case 1 :
					calc(sum - nums[cnt+1], cnt+1, n);
					break;
				case 2 :
					calc(sum * nums[cnt+1], cnt+1, n);
					break;
				case 3 :
					calc(sum / nums[cnt+1], cnt+1, n);
					break;
			}
			operator[j]++;
		}
		
	}
}