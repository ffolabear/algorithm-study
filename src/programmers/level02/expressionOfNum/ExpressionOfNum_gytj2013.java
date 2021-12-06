package programmers.level02.expressionOfNum;

class ExpressionOfNum_gytj2013 {
    public static int solution(int n) {
        int answer = 1;
        int sum = 1+2;
        int num = 2;
        int cnt = 1;
        
        while(n>=sum) {
        	if(num%2==0) {
        		if(n%num==cnt) {
        			answer++;
        		}
        		cnt++;
        	}else {
        		if(n%num==0) {
        			answer++;
        		}
        	}
        	sum += ++num;
        }
        
        return answer;
    }
}