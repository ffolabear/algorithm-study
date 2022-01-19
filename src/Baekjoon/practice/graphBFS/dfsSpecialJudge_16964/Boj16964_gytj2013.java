package Baekjoon.practice.graphBFS.dfsSpecialJudge_16964;

import java.io.*;
import java.util.*;

class Boj16964_gytj2013{
	public static void main(String[] args) throws IOException {
		ArrayList<Set<Integer>> tree = new ArrayList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] order = new int[N];
		for (int i = 0; i <=N; i++) {
            tree.add(new HashSet<>());
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
		}
		if(order[0] != 1) {
			System.out.println(0);
			return;
		}
		boolean chk = true;
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N-1; i++) {
			stack.add(order[i]);
			int child = order[i+1];
			while(!stack.isEmpty()) {
				int e = stack.pop();
				if(tree.get(e).contains(child)){
					tree.get(e).remove(child);
					tree.get(child).remove(e);
					if(!tree.get(e).isEmpty()) {
						stack.add(e);
					}
					break;
				}else if(!tree.get(e).isEmpty()) {
					chk=false;
					break;
				}
			}
			if(!chk) {break;}
		}
		if(chk) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}