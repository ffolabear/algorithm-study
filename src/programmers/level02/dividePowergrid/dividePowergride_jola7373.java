package programmers.level02.dividePowergrid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class dividePowergride_jola7373 {
    public static void main(String[] args) {
        int n = 7;
        int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        int a =n;
        for(int i=0; i < wires.length; i++){
            int one = check(i,wires);
            int other = n-one;
            int temp = Math.abs(one-other);
            a = Math.min(a,temp);
        }
        return a;
    }

    public static int check(int idx, int[][] wires ){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<int[]> one = new ArrayList<>();
        for(int[] o : wires){
            one.add(o);
        }
        q.add(one.get(idx)[0]);
        one.remove(idx);
        while(!q.isEmpty()){
            int temp = q.remove();
            for(int i=0; i < one.size(); i++){
                boolean c = true;
                if(one.get(i)[0]== temp) {
                    q.add(one.get(i)[1]);
                    one.remove(i);
                    c = false;
                }else if(one.get(i)[1] == temp){
                    q.add(one.get(i)[0]);
                    one.remove(i);
                    c = false;
                }
                if(c==false){
                    i--;
                }
            }
            count++;
        }
        System.out.println(count);
        return count;
    }
}
