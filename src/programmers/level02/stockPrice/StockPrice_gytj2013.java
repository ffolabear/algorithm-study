package programmers.level02.stockPrice;

class StockPrice_gytj2013 {
    public static int[] solution(int[] prices) {
    	int len = prices.length;
        int[] answer = new int[len];
        
        answer[len-1]=0;
        
        for(int i=len-2; i>=0; i--) {
        	int add=1;
        	while(true) {
	        	if(prices[i]<prices[i+add]) {
	        		if(i+add==len-1) {answer[i]=add;break;}
	        		add++;
	        	}else if(prices[i]==prices[i+add]) {
	        		answer[i]=add+answer[i+add];
	        		break;
	        	}else {answer[i]=add; break;}
        	}
        }
        return answer;
    }
}