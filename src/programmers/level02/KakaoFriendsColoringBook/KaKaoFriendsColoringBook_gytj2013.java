import java.util.*;

class Node {
	int x; int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Solution {
	int[] dx = {-1, 0, 1, 0}; //상우하좌 
	int[] dy = {0, 1, 0, -1};
	boolean[][] visited; //방문여부 
			
 	public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0; //영역 개수 
        int maxSizeOfOneArea = 0; //가장 큰 영역 넓이 
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(picture[i][j]!=0 & !visited[i][j]) {
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(m, n, i, j, picture));
        			numberOfArea++;
        		}
        	}
        }
        
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    private int bfs(int m, int n, int x, int y, int[][] picture) {
    	int size = 1;
    	Queue<Node> q = new LinkedList<>();
    	
		visited[x][y] = true;
		q.add(new Node(x, y));
		
		while(!q.isEmpty()) {
			Node a = q.poll();
			for(int i=0; i<4; i++)
			{
				int post_x = a.x + dx[i];
				int post_y = a.y + dy[i];
				
				if(post_x >= 0 & post_x < m & post_y >= 0 & post_y < n) {
					if(picture[post_x][post_y]==picture[x][y] & !visited[post_x][post_y]) {
						q.add(new Node(post_x, post_y));
						visited[post_x][post_y] = true;
						size++;
					}
				}
			}
		}
		return size;
	}
}