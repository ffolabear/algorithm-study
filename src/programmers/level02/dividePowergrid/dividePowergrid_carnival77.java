package programmers.level02.dividePowergrid;

import java.util.*;

public class dividePowergrid_carnival77 {
    static ArrayList<Integer>[] g;

    public int solution(int n, int[][] wires) {
        int answer = n;

        // 노드 간의 연결 관계를 나타내는 링크드 리스트 선언
        g=(ArrayList<Integer>[]) new ArrayList[n+1];

        for (int i=0; i<n+1; i++) {
            g[i] = new ArrayList<Integer>();
        }

        // 연결 관계 삽입
        for(int i=0;i< wires.length;i++){
            int from = wires[i][0], to = wires[i][1];
            g[from].add(to);
            g[to].add(from);
        }

        // wire 하나씩 끊고 bfs 돌려서 노드 개수 차이 구한 다음 다시 wire 복구
        for(int[] wire : wires){
            int from = wire[0], to = wire[1];
            g[from].remove(Integer.valueOf(to));
            g[to].remove(Integer.valueOf(from));

            answer = Math.min(answer,Math.abs(bfs(from,n) - bfs(to,n)));

            g[from].add(to);
            g[to].add(from);
        }

        return answer;
    }

    public int bfs(int node, int n){
        int cnt=0;
        boolean[] visited = new boolean[n+1];
        visited[node]=true;

        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        while(!q.isEmpty()){
            int this_node = q.poll();

            for(Integer next_node : g[this_node]){
                if(!visited[next_node]) {
                    visited[next_node] = true;
                    q.add(next_node);
                    cnt+=1;
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        dividePowergrid_carnival77 sol = new dividePowergrid_carnival77();

        System.out.println(sol.solution(n,wires));
    }
}
