package programmers.level02.gameMapShortestDistance;

import java.util.*;

class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class GameMapShortestDistance_carnival77 {

    public static final int[] dx={-1,1,0,0};
    public static final int[] dy={0,0,-1,1};

    public int solution(int[][] maps) {

        int answer = 0;

        Queue<Pair> q = new LinkedList<>();

        int n=maps.length;
        int m=maps[0].length;

        int x=0;
        int y=0;
        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = -1;
            }
        }

        q.add(new Pair(x,y));
        dist[0][0]=1;

        while(!q.isEmpty()){
            Pair p = q.poll();
            x=p.x;
            y=p.y;

            for(int k=0;k<4;k++){
                int nx=x+dx[k];
                int ny=y+dy[k];

                if(0<=nx && nx<n && 0<=ny && ny<m && dist[nx][ny]==-1 && maps[nx][ny] == 1){
                    dist[nx][ny]=dist[x][y]+1;
                    if(nx==n-1 && ny==m-1)
                        return dist[nx][ny];
                    else
                        q.add(new Pair(nx,ny));
                }
            }
        }


        return -1;
    }
}
