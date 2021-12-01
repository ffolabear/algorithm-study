package programmers.level02.findingBiggestSquare;

class FindingBiggestSquare_gytj2013{
    public static int solution(int [][]board){
        int answer = 0;
       
        for(int i=1; i<board.length; i++) {
        	for(int j=1; j<board[0].length; j++) {
        		if(board[i][j]!=0) {
        			board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1]))+1;
        			answer = Math.max(board[i][j], answer);
        		}
        	}
        }
        if(answer==0) {
        	for(int i=0; i<board.length; i++) {
        		if(board[i][0]==1) {
        			answer=1;
        			break;
        		}
        	}
        }
        if(answer==0) {
        	for(int j=1; j<board[0].length; j++) {
        		if(board[0][j]==1) {
        			answer=1;
        			break;
        		}
        	}
        }
        
        return answer*answer;
    }
}