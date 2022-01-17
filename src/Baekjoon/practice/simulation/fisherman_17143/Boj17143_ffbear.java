package Baekjoon.practice.simulation.fisherman_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17143_ffbear {

    static int R, C, M;
    static shark[][] board;
    static int answer = 0;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //낚시터 세로
        R = Integer.parseInt(st.nextToken());

        //낚시터 가로
        C = Integer.parseInt(st.nextToken());

        //상어 숫자
        M = Integer.parseInt(st.nextToken());


        //낚시터
        board = new shark[R][C];


        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()); // 행 위치
            int c = Integer.parseInt(st.nextToken()); // 열 위치
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 이동 방향
            int z = Integer.parseInt(st.nextToken()); // 크기

            if (d == 1) {

                d = 0;
            } else if (d == 4) {
                d = 1;

            }

            shark shark1 = new shark(r - 1, c - 1, s, d, z);

            board[r - 1][c - 1] = shark1;


        }


        for (int i = 0; i < C; i++) {

            for (int j = 0; j < R; j++) {
                if (board[j][i] != null) {
                    answer += board[j][i].z;
                    board[j][i] = null;
                    break;
                }

            }


            move();

        }

        //상어번호 : 위치 r,c / 속력 / 이동 방향 / 크기

        System.out.println(answer);


    }


    static void move() {

        Queue<shark> queue = new LinkedList<>();

        //움직일 상어들의 리스트
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] != null) {
                    queue.add(new shark(i, j, board[i][j].s, board[i][j].d, board[i][j].z));
                }
            }
        }

        board = new shark[R][C];

        while (!queue.isEmpty()) {

            shark current = queue.poll();

            int speed = current.s;

            if (current.d == 0 || current.d == 2) {
                speed %= (R - 1) * 2;
            }

            if (current.d == 1 || current.d == 3) {
                speed %= (C - 1) * 2;
            }

            //상어 이동시키기
            for (int i = 0; i < speed; i++) {

                int nx = current.r + dx[current.d];
                int ny = current.c + dy[current.d];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    current.r -= dx[current.d];
                    current.c -= dy[current.d];

                    current.d = (current.d + 2) % 4;
                    continue;
                }

                current.r = nx;
                current.c = ny;
            }

            //상어 잡아먹기
            if (board[current.r][current.c] != null) {
                if (board[current.r][current.c].z < current.z) {
                    board[current.r][current.c] = new shark(current.r, current.c, current.s, current.d, current.z);
                }
            } else {
                board[current.r][current.c] = new shark(current.r, current.c, current.s, current.d, current.z);
            }


        }



    }

}

class shark {

    int r; // 행 위치
    int c; // 열 위치
    int s; // 속력
    int d; // 방향
    int z; // 크기

    shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }

}

