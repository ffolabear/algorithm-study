package programmers.level02.printer;

import java.util.Arrays;

class Printer_gytj2013 {
    public int solution(int[] priorities, int location) {
    	int[] tmp = priorities.clone();
    	int answer = 0;
        int tmpLen = tmp.length-1;
        int ready = 0;
       
        while(true) {
        	Arrays.sort(tmp);
        	if(priorities[ready]==tmp[tmpLen]) {
        		tmp[tmpLen] = 0;
        		answer++;
        		if(ready==location) {return answer;}
        	}
        	ready++;
        	if(ready > tmpLen) {ready=0;}
        }
    }
}