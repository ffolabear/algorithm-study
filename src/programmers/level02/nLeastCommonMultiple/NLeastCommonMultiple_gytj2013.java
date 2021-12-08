package programmers.level02.nLeastCommonMultiple;

import java.util.ArrayList;

class NLeastCommonMultiple_gytj2013 {
    public static int solution(int[] arr) {
        int answer = 1;
        
        for(int i=0; i<arr.length; i++) {
        	answer *= arr[i];
        	System.out.println(arr[i]);
        	for(int a : factor(arr[i])) {
        		for(int j=i; j<arr.length; j++) {
        			if(arr[j]%a==0) {arr[j]/=a;}
        		}
        	}
        }
     
        return answer;
    }
    private static ArrayList<Integer> factor(int a) {
    	ArrayList<Integer> list = new ArrayList<>();
    	list.add(1);
    	for(int i = 2; i <= Math.sqrt(a); i++) {
    		while(a % i == 0) {
    			list.add(i);
    			a /= i;
    		}
		}
    	if(a != 1) { list.add(a); }
    	return list;
	}
}