package programmers.level02.delivery;
class Delivery_gytj2013{
    public static int solution(int N, int[][] road, int K) {
    	int answer=1;
        int arr[][] = new int[N][N];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		arr[i][j]=K+1;        		
        	}
        }
      
        for(int i=0; i<road.length; i++) {
        	arr[road[i][0]-1][road[i][1]-1] = Math.min(road[i][2], arr[road[i][0]-1][road[i][1]-1]);
        	arr[road[i][1]-1][road[i][0]-1] = Math.min(road[i][2], arr[road[i][1]-1][road[i][0]-1]);
        }
        
        for(int k=0; k<N; k++) {
	        for(int i=0; i<N; i++) {
	        	for(int j=0; j<N; j++) {
	        		if(i==j) {continue;}//꼭 필요했던 부분!
	        		arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
	       		}
	        } 
        }
        
        for(int i=0; i<N; i++) {
        	if(arr[i][0]<=K) {answer++;}
        }
        
        return answer;
    }
}