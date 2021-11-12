package programmers.level02.friendsBlock;

class FriendsBlock_gytj2013.java {
    public static int solution(int m, int n, String[] board) {
    	int answer =0;
    	char[][] block = new char[m][n];
    	
    	for(int i=0; i<m; i++) {
    		block[i] = board[i].toCharArray();
    	}
    	
    	while(true) {
    		int cnt = checkBlock(m, n, block);
			if(cnt == 0) break;
			answer += cnt;
			dropBlock(m, n, block);
    	}
    	
    	return answer;
    }
    private static void dropBlock(int m, int n, char[][] block) {
    	for(int j=0; j<n; j++) {
    		int idx=m-1;
    		for(int i=m-1; i>=0; i--){
    			//System.out.print(block[i][j]);
    			if(block[i][j]!='0') {
    				block[idx][j]=block[i][j];
    				if(i!=idx) {block[i][j] ='0';}
    				idx--;
    			}
    		}
    	}
	}
	private static int checkBlock(int m, int n, char[][] block) {
		int cnt = 0;
		boolean[][] check = new boolean[m][n];
		
		for(int i=0; i<m-1; i++) {
			for(int j=0; j<n-1; j++) {
				if(block[i][j] == '0') continue;
				char target = block[i][j];
				if(target!=block[i+1][j]) {continue;}
				if(target!=block[i][j+1]) {continue;}
				if(target!=block[i+1][j+1]) {continue;}
				check[i][j] = true;
				check[i+1][j] = true;
				check[i][j+1] = true;
				check[i+1][j+1] = true;

			}
		}
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(check[i][j]) {
					cnt++;
					block[i][j] = '0';
				}
			}
		}
		
		return cnt;
	}
}