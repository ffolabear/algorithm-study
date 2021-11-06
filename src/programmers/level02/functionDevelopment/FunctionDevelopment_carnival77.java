package programmers.level02.functionDevelopment;

import java.util.*;

class Pair{
    private int x;
    private int y;

    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}

public class FunctionDevelopment_carnival77 {
    public int[] solution(int[] progresses, int[] speeds) {
//        int[] answer = {};

        ArrayList<Integer> result = new ArrayList<>();

//        Queue<Pair> q = new LinkedList<>();

        ArrayList<Pair> q = new ArrayList<>();

        for(int i=0;i<progresses.length;i++){
            Pair pair = new Pair(progresses[i],speeds[i]);
            q.add(pair);
        }

        while(q.isEmpty()){
            int cnt=0;
            for(int i=0;i<q.size();i++){
                if(q.get(i).getX() >= 100){
                    continue;
                }
                else{
                    int temp = q.get(i).getX() + q.get(i).getY();
                    Pair pair = new Pair(temp,q.get(i).getY());
                    q.set(i,pair);
                    if (q.get(i).getX() >= 100){
                        Pair pair2 = new Pair(100,q.get(i).getY());
                        q.set(i,pair2);
                    }
                }
            }
            while(true){
                int first=0;
                try {
                    first = q.get(0).getX();
                } catch (Exception e) {
                    break;
                }
                if(first == 100){
                    cnt+=1;
                    q.remove(0);
                }
                else{
                    break;
                }
            }
            if(cnt>0){
                result.add(cnt);
            }
        }

        int[] answer = new int[result.size()];

        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }



        return answer;
    }

    public static void main(String[] args) {


        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        FunctionDevelopment_carnival77 sol = new FunctionDevelopment_carnival77();
        sol.solution(progresses,speeds);

    }
}
