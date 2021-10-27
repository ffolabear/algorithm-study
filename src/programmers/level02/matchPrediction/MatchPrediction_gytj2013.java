package programmers.level02.matchPrediction;
import java.util.LinkedList;
import java.util.Queue;

class MatchPrediction_gytj2013{
    public static int solution(int n, int a, int b)
    {
    	Queue<Integer> q = new LinkedList<>();
    	int answer = 1;
    	
    	if(a>b) {
    		int tmp = a;
    		a=b;
    		b=tmp;
    	}
    
    	if(b-a==1 & a/2+1==b/2) {return answer;}
    	 
    	for(int i=1; i<n; i=i+2) {
    		if(i+1==a | i+1==b) {q.add(i+1);}
    		else {q.add(i);}
    	}
    	
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		int y = q.poll();
    		if(a==x | a==y) {answer++;}
    		if(x==a) {
    			if(y==b) {break;}
    			else {q.add(a);}
    		}
    		else if(x==b) {q.add(b);}
    		else {q.add(y);}
    	}
    	
    
        return answer;
    }
    public static void main(String[] args) {
    	System.out.println(solution(8,4,1));
    }
}