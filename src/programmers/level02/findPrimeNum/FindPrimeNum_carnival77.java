package programmers.level02.findPrimeNum;

import java.util.*;

public class FindPrimeNum_carnival77 {

    static int answer = 0 ;
    static boolean[] used = new boolean[7];
    static ArrayList<Integer> arr = new ArrayList<>();
    static String num;

    public void dfs(String str, int m){
        if(str.length() == m) {
            if (!arr.contains(Integer.parseInt(str)))
                arr.add(Integer.parseInt(str));
            return;
        }

        for(int i=0;i<num.length();i++){
            if(used[i])
                continue;
            used[i]=true;
            str+=num.charAt(i);
            dfs(str,m);
            used[i]=false;
            str=str.substring(0,str.length()-1);
        }
    }

    public void prime(int x){
        if(x==0) return;
        if(x==1) return;

        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0) return;
        }

        answer+=1;
    }

    public int solution(String numbers) {
        num = numbers;
        // 1. 주어진 numbers의 순열의 모든 경우의 수를 조합
        for(int i=1;i<numbers.length()+1;i++){
            dfs("",i);
        }
        // 2. 해당 숫자들 중 소수 판별
        for(int x:arr){
            prime(x);
        }
        return answer;
    }

    public static void main(String[] args) {
        String numbers = "17";
        FindPrimeNum_carnival77 sol = new FindPrimeNum_carnival77();
        System.out.println(sol.solution(numbers));
    }
}
