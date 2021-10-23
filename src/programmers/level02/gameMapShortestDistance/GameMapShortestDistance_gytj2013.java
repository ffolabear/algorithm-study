package programmers.level02.gameMapShortestDistance;
import java.util.LinkedList;
import java.util.Queue;

class GameMapShortestDistance_gytj2013 {
	private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int[][] map;
    static class Point {
        int x;int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int solution(int[][] maps) {
    	int n = maps.length-1;
    	int m = maps[0].length-1;
    	boolean[][] visited = new boolean[n+1][m+1];
    	map=new int [n+1][m+1];
    	bfs(0,0, maps, visited);

    	if(map[n][m]==0) {return -1;}
    	else {return map[n][m];}
    }
    public static void bfs(int x, int y, int[][] maps, boolean[][] visited) {
    	Queue<Point> q = new LinkedList<>();
    	int n = maps.length-1;
    	int m = maps[0].length-1;
    	map[x][y]=1;
    	q.add(new Point(x, y));
    	visited[x][y] = true;

    	while(!q.isEmpty()) {
    		Point point = q.poll();
    		if(point.x==n & point.y==m) {
        		break;
        	}
	    	for(int i = 0; i < 4; i++) {
	    		int x2=point.x+dx[i];
	    		int y2=point.y+dy[i];
	    		if(x2<0 | y2<0 | x2>n | y2>m) {continue;}
	    		if(maps[x2][y2] == 1 & !visited[x2][y2]) {
	    			q.add(new Point(x2, y2));
	    			visited[x2][y2] = true;
	    			 map[x2][y2] = map[point.x][point.y] + 1;

	    		}
	    	}
    	}
    }
}
