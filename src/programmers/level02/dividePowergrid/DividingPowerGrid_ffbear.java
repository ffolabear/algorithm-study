package programmers.level02.dividePowergrid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DividingPowerGrid_ffbear {

    static List<List<Integer>> nodes;

    public int solution(int n, int[][] wires) {

        int answer = 100;

        nodes = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < wires.length; i++) {
            nodes.get(wires[i][0]).add(wires[i][1]);
            nodes.get(wires[i][1]).add(wires[i][0]);
        }

        for (int[] wire : wires) {
            int node1 = dfs(wire[0], wire[1], n);
            int node2 = dfs(wire[1], wire[0], n);

            answer = Math.min(answer, Math.abs(node1 - node2));
        }

        return answer;
    }

    static int dfs(int node1, int node2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        int cnt = 0;
        queue.add(node1);
        visited[node1] = true;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            cnt++;

            for (int next : nodes.get(current)) {
                if (next != node2 && !visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

//        int n = 4;
//        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};

//        int n = 7;
//        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};


        DividingPowerGrid_ffbear sol = new DividingPowerGrid_ffbear();
        sol.solution(n, wires);

    }
}
