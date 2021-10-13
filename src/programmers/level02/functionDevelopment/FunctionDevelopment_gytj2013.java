package programmers.level02.functionDevelopment;

import java.util.ArrayList;

class FunctionDevelopment_gytj2013 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] dayleft = new int[progresses.length];
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for(int i =0; i<progresses.length;i++) {
        	int tmp = 100 - progresses[i];
        	dayleft[i] = tmp / speeds[i];
        	if(tmp%speeds[i]!=0) {dayleft[i]++;}
        }
        
        int cnt=1;
        int tmp = dayleft[0];
        
        for(int i =1; i<progresses.length;i++) {
        	if(dayleft[i] <= tmp) {cnt++;}
        	else {
        		answer.add(cnt);
        		cnt = 1;
        		tmp = dayleft[i];
        	}
        }
        answer.add(cnt);
       
        return  answer.stream().mapToInt(i->i).toArray();
    }
}