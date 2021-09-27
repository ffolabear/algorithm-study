
class Solution {
    public int solution(String s) {
        int answer =1001;
        for(int i=1; i<s.length()/2+1; i++){
            String sample = s.substring(0,i);
            int counting=1;
            String enc = "";
            String last = "";
            for(int j=i; j<s.length();j+=i){
                if (j + i > s.length()) {
                    last = s.substring(j);
                    continue;
                }
                if(sample.equals(s.substring(j, j + i))){
                    counting++;
                }else {
                    enc += sample;
                    if (counting != 1) {
                        enc = counting + enc;
                    }
                    sample = s.substring(j, j + i);
                    counting = 1;
                }  
            }
            enc += sample + last;
            if (counting != 1){
                enc = counting + enc;
            } 
            answer = Math.min(answer, enc.length());
        }return answer;
    }
}