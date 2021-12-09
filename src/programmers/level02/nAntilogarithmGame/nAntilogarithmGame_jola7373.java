package programmers.level02.nAntilogarithmGame;

public class nAntilogarithmGame_jola7373 {
    public String solution(int n, int t, int m, int p) {

        String answer = "";
        String whole = "";
        int count =0;

        //전체게임에서 나오는 숫자를 whole에 담는다.
        while(whole.length() < (t*m)+p){
            whole += conversion(count, n);
            count++;
        }

        System.out.println(whole);

        //whole에서 튜브 차례만 뽑아낸다.
        for(int i=0; i < t; i++){
            answer += whole.charAt((p + (i * m))-1);
        }
        return answer;
    }

    //n진법에 맞게 반환해 주는 함수이다.
    public String conversion(int number, int n){
        StringBuilder sb = new StringBuilder();
        if(number == 0){
            sb.append(0);
        }
        while(number > 0 ){
            if(number % n < 10){
                sb.append((number % n));
            }else{
                sb.append((char)(number % n-10 +'A'));
            }
            number /= n;
        }
        return(sb.reverse().toString());
    }
}
