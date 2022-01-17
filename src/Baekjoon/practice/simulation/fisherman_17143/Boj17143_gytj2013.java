package Baekjoon.practice.simulation.fisherman_17143;

import java.io.*;
import java.util.*;

class Shark{
	int s, d, z; // 속력, 이동 방향, 크기 
	Shark(int s, int d, int z){
		this.s=s;
		this.d=d;
		this.z=z;
	}
}

class Boj17143_gytj2013{
	static int R, C, M;
	static Shark[][] info;
	static int[] dx = {-1, 1, 0, 0}; // 위, 아래, 오른쪽, 왼쪽 
	static int[] dy = {0, 0, 1, -1};
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		info = new Shark[R+1][C+1];
		if(M==0) { 
			System.out.println(0);
			return;		
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			info[r][c] = new Shark(s, d-1, z);
		}
		
		for(int i=1; i<=C; i++) {
			int z = catchShark(i);
			answer+=z;
			moveShark(z);
		}
		System.out.println(answer);
	}

	private static void moveShark(int z) {
		Shark[][] tmp = new Shark[R+1][C+1];
		for(int r=1; r<=R; r++) {
			for(int c=1; c<=C; c++) {
				Shark sh = info[r][c];
				if(sh!=null) {
					int dir = sh.d;
					int row = r;
					int col = c;
					for(int i=0; i<sh.s; i++) {
						if(row+dx[dir]>=1 & row+dx[dir]<=R & col+dy[dir]>=1 & col+dy[dir]<=C) {
							row += dx[dir];
							col += dy[dir];
						}else {
							switch(dir) {
								case 0 : dir = 1; break;
								case 1 : dir = 0; break;
								case 2 : dir = 3; break;
								case 3 : dir = 2; break;
							}
							i--;
						}
					}
					
					if(tmp[row][col]!=null) {
						if(tmp[row][col].z>sh.z) {
							continue;
						}
					}
					tmp[row][col] =  new Shark(sh.s, dir, sh.z);
					
				}
			}
		}
		info = tmp;
	}

	private static int catchShark(int c) {
		for(int r=1; r<=R; r++) {
			if(info[r][c]==null) {continue;}
			int z = info[r][c].z;
			if(z != 0) {
				info[r][c] = null;
				return z;
			}
		}
		return 0;
	}
}