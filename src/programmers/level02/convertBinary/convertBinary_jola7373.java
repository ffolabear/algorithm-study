package programmers.level02.convertBinary;

public class convertBinary_jola7373 {
    public static void main(String[] args) {
        String s = "110010101001";
        int [] ans = solution(s);
        System.out.println(ans[0] + ":" +ans[1]);
    }
    public static int[] solution(String s) {
        //왜 여기 1넣으면 되는거지......
        int[] answer = {1,0};
        answer[1] += s.chars().filter(ch -> ch == '0').count();
        s=s.replaceAll("0","");
        while(!s.equals("1")){
            answer[0]++;
            s = Integer.toBinaryString(s.length());
            answer[1] += s.chars().filter(ch -> ch == '0').count();
            s=s.replaceAll("0","");
        }
        return answer;
    }
}
