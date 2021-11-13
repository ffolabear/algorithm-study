package programmers.level02.TwoDifferentBit;

public class TwoDifferentBit_jola7373 {
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i < numbers.length; i++){
            answer[i] = findBit(numbers[i]);
            System.out.println(answer[i]);
        }

        return answer;
    }
    public static long findBit(long n){
        long a = n+1;
        while (true){
            long temp = n ^ a;
            int count = 0 ;
            String t= Long.toBinaryString(temp);
            for(int i =0; i < t.length(); i++){
                if(count > 3){
                    break;
                }else{
                    if(t.charAt(i) == '1'){
                        count++;
                    }
                }
            }

            if(count <= 2) {
                return a;
            }
            a++;
        }
    }
}
