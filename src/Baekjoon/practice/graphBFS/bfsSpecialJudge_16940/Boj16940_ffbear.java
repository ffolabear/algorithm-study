package Baekjoon.practice.graphBFS.bfsSpecialJudge_16940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16940_ffbear {

	static int N;
	static ArrayList<Integer>[] adj;
	static Queue<Integer> order = new LinkedList<>();


	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];


		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}


		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());


			adj[from].add(to);
			adj[to].add(from);

		}

		String[] row = br.readLine().split(" ");
		for (int i = 0; i < row.length; i++) {
			order.add(Integer.parseInt(row[i]));
		}

		if(order.poll()!=1) {
			System.out.println(0);
			return;
		}

		if (bfs()) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}


	}

	static boolean bfs() {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		queue.add(1);

		while(!queue.isEmpty()) {
			int temp = queue.poll();
			HashSet<Integer> set = new HashSet<>();

			for(int next : adj[temp]) {
				if(visited[next]) continue;

				visited[next] = true;
				set.add(next);
			}

			if(set.size()==0) continue;

			for(int i=0; i<set.size(); i++) {
				int next = order.poll();

				if(set.contains(next))
					queue.add(next);

				else
					return false;
			}
		}

		return true;
	}


}
