package programmers.level02.rotatingMatrixBorder;

class RotatingMatrixBorder_gytj2013 {
    public int[] solution(int rows, int columns, int[][] queries) {
    	int[][] arr = new int[rows][columns];
        int[] answer = new int[queries.length]; 
             
        for(int i=0; i< queries.length; i++) {
        	int x=queries[i][0]-1;
        	int y;
        	int tmp = arr[x][queries[i][1]-1];
        	int tmp2;
        	answer[i] = 100*100;
        	for(y=queries[i][1]; y<queries[i][3]; y++) {
        		tmp2 = arr[x][y];
        		if(tmp!=0) {
        			arr[x][y] = tmp;
        		}
        		else {
        			arr[x][y] = x*columns+y;
        		}
        		tmp = tmp2;
        		answer[i] = answer[i] > arr[x][y] ? arr[x][y] : answer[i];
        	}
        	y=queries[i][3]-1;
        	for(x=queries[i][0]; x<queries[i][2]; x++) {
        		tmp2 = arr[x][y];
        		if(tmp!=0) {
        			arr[x][y] = tmp;
        		}
        		else {
        			arr[x][y] = (x-1)*columns+(y+1);
        		}
        		tmp = tmp2;
        		answer[i] = answer[i] > arr[x][y] ? arr[x][y] : answer[i];
        	}
        	x=queries[i][2]-1;
        	for(y=queries[i][3]-2; y>queries[i][1]-2; y--) {
        		tmp2 = arr[x][y];
        		if(tmp!=0) {
        			arr[x][y] = tmp;
        		}
        		else {
        			arr[x][y] = x*columns+y+2;
        		}
        		tmp = tmp2;
        		answer[i] = answer[i] > arr[x][y] ? arr[x][y] : answer[i];
        	}
        	y=queries[i][1]-1;
        	for(x=queries[i][2]-2; x>queries[i][0]-2; x--) {
        		tmp2 = arr[x][y];
        		if(tmp!=0) {
        			arr[x][y] = tmp;
        		}
        		else {
        			arr[x][y] = (x+1)*columns+(y+1);
        		}
        		tmp = tmp2;
        		answer[i] = answer[i] > arr[x][y] ? arr[x][y] : answer[i];
        	}
        }
        return answer;
    }
}