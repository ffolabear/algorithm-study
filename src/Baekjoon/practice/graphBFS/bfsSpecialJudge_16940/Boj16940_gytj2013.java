package Baekjoon.practice.graphBFS.bfsSpecialJudge_16940;

import java.io.*;
import java.util.*;

class Boj16940_gytj2013{
	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] order = new int[N];
		boolean[] visited = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i <=N; i++) {
            tree.add(new ArrayList<>());
        }
		StringTokenizer st;
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
			q.add(order[i]);
		}
		if(order[0] != 1) {
			System.out.println(0);
			return;
		}
		HashSet<Integer> set = new HashSet<>();
		int i=0;
		visited[q.poll()] = true;
		while(!q.isEmpty()) {
			set.clear();
			int target = order[i];
			for(int n : tree.get(target)) {
				if(visited[n]) continue;
				set.add(n);
				visited[n] = true;
			}
			for(int j=0; j<set.size(); j++) {
				int next = q.poll();
				if(!set.contains(next)) {
					System.out.println(0);
					return;
				}
			}
			i++;
		}
		System.out.println(1);
	}
}