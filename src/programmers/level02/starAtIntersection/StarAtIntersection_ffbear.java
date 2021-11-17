package programmers.level02.starAtIntersection;

import java.util.HashSet;
import java.util.Set;

public class StarAtIntersection_ffbear {


    static int nx = Integer.MAX_VALUE;
    static int px = Integer.MIN_VALUE;

    static int py = Integer.MIN_VALUE;
    static int ny = Integer.MAX_VALUE;

    static StringBuilder coordinates = new StringBuilder();
    static Set<String> hs = new HashSet<>();

    public String[] solution(int[][] line) {


        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {

                intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

            }

        }

        String[] answer = new String[py - ny + 1];

        System.out.println(coordinates);

        for (int i = py; i >= ny; i--) {
            StringBuilder row = new StringBuilder();
            for (int j = nx; j <= px; j++) {
                if (hs.contains(j + "," + i)) {
                    row.append("*");
                } else {
                    row.append(".");
                }
            }

            answer[py - i] = row.toString();
            System.out.println(answer[py - i]);
        }

        return answer;
    }

    static void intersection(int x1, int y1, int m, int x2, int y2, int n) {

        long A = x1;
        long B = y1;
        long E = m;

        long C = x2;
        long D = y2;
        long F = n;

        //분자
        long xNumerator = B * F - E * D;
        long yNumerator = E * C - A * F;

        //분모
        long denominator = A * D - B * C;

        //분모가 0일수는 없음
        if (denominator == 0) {
            return;
        }

        //정수좌표만 찾아야함
        if (xNumerator % denominator != 0 || yNumerator % denominator != 0) {
            return;
        }

        int x = (int)xNumerator / (int)denominator;
        int y = (int)yNumerator /(int) denominator;


        px = Math.max(px, (int) x);
        nx = Math.min(nx, (int) x);

        py = Math.max(py, (int) y);
        ny = Math.min(ny, (int) y);

//        coordinates.append((int) x).append(",").append((int) y).append(" ");
        hs.add(x + "," + y);
    }


    public static void main(String[] args) {

        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//        int[][] line = {{2, -1, 4}, {-2, -1, 4},{1, 0, -1}, {1, 0, 1} };
//        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
//        int[][] line = {{1, -1, 0}, {2, -1, 0}};
//        int[][] line = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};

        StarAtIntersection_ffbear sol = new StarAtIntersection_ffbear();
        sol.solution(line);


    }
}
