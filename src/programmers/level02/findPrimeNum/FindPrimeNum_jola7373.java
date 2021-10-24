package programmers.level02.findPrimeNum;
import java.util.ArrayList;
public class FindPrimeNum_jola7373 {
    static int answer = 0;
    //조합들을 저장할 arraylist
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean []check = new boolean[7];
    public static void group(String n, String temp, int len){
        if(temp.length()==len){
            //arraylist에 이미 조합이 있는지 확인 후 없으면 삽입
            if(! arr.contains(Integer.parseInt(temp)))
                arr.add(Integer.parseInt(temp));
            return;
        }

        for(int j=0; j<n.length(); j++){
            //이미 방문한 인덱스면 패스
            if(check[j])continue;
            temp+=n.charAt(j);
            check[j]=true;
            //재귀 호출
            group(n,temp,len);
            //조합 완료시 각 인덱스 false
            check[j] = false;
            temp = temp.substring(0,temp.length()-1);
        }
    }

    public static void cal(int n){
        if(n==0 || n==1){//0과 1 이면 소수가 아니므로
            return;
        }
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0)return;
        }
        answer++;
    }

    class Solution {

        public int solution(String numbers) {
            String temp="";
            for( int i=1; i<=numbers.length(); i++){
                group(numbers,temp,i);
            }
            for(int x: arr){
                cal(x);
            }

            return answer;

        }
    }
}
