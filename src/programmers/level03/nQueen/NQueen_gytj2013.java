package programmers.level03.nOueen;

class NQueen_gytj2013 {
	static int cnt = 0;
    public static int solution(int n) {
    	if(n==1) {return 1;}
    	if(n<4) {return 0;}
        boolean[][] arr = new boolean[n][n];
        
        for(int x=0; x<n; x++) {
        	dfs(arr, 0, x, n);
        	arr[0][x] = false;
        }
        
        return cnt;
    }
    private static void dfs(boolean[][] arr, int i, int j, int n) {
    	if(i==n-1) {
    		 for(int x=0; x<n; x++) {
    			 if(check(arr,i,x,n)) {cnt++;}
    		 }
    		 return;
    	}
    	arr[i][j] = true;
    	
    	for(int x=0; x<n; x++) {
    		if(check(arr,i+1,x,n)) {
    			dfs(arr, i+1, x, n);
    			arr[i+1][x] = false;
    		}
		}
	}
	private static Boolean check(boolean[][] arr, int i, int j, int n) {
		for(int x=0; x<i+1; x++) {
			if(arr[x][j]) {return false;}
			if(j-x>=0) {
				if(arr[i-x][j-x]) {return false;}
			}
			if(j+x<n) {
				if(arr[i-x][j+x]) {return false;}
			}
		}
		return true;
	}
}