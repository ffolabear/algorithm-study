package programmers.level02.starAtIntersection;

import java.util.*;

/* 배울 점
1. 무한에 수렴하는 큰 값 표현할 때, Long.MIN_VALUE, Long.MIN_VALUE 사용
2. char 배열 빈 칸 채울 때, Arrays.fill(m, '.'); 사용
3. foreach 문 활용하여 심플하게 나타내기. for(long[] a : list) map[(int)(max_Y -a[1])][(int)(a[0] -min_X)] = '*';

 */

public class starAtIntersection_carnival77 {
    public String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        int n = line.length;

        long  max_X = Long.MIN_VALUE, max_Y = Long.MIN_VALUE, min_X = Long.MAX_VALUE, min_Y =Long.MAX_VALUE;

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                double a=line[i][0], b=line[i][1], e=line[i][2], c=line[j][0], d=line[j][1], f=line[j][2];
                double mod = a*d - b*c;
                if(mod == 0) continue;
                double x=(b*f-e*d)/mod, y=(e*c-a*f)/mod;
                long ix=(long)x; long iy=(long)y;
                if(x== ix && y==iy) {
                    min_X = Math.min(ix, min_X);
                    max_X = Math.max(ix, max_X);
                    min_Y = Math.min(iy, min_Y);
                    max_Y = Math.max(iy, max_Y);
                    list.add(new long[] { ix, iy });
                }
            }
        }

        int h = (int)(max_Y - min_Y + 1);
        int w = (int)(max_X-min_X + 1);

        char[][] map = new char[h][w];
        for(char[] m : map) Arrays.fill(m, '.');
        for(long[] a : list) map[(int)(max_Y -a[1])][(int)(a[0] -min_X)] = '*';
        String[] answer = new String[map.length];
        for(int i = 0; i < map.length; i++) answer[i] = new String(map[i]);
        return answer;
    }

    public static void main(String[] args) {
        starAtIntersection_carnival77 sol = new starAtIntersection_carnival77();

        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};

        sol.solution(line);
    }

}
