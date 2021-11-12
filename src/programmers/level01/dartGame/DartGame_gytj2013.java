package programmers.level01.dartGame;

class DartGame_gytj2013 {
    public static int solution(String dartResult) {
        int answer = 0;
        int first=0;
        int second=0;
        int idx=0;
        
        while(true) {
        	if(idx>=dartResult.length()) {answer+=second;System.out.println(second); break;}
        	if(dartResult.substring(idx, idx+2).equals("10")) {
        		second=10;
        		idx++;
        	}else {
        		second = dartResult.charAt(idx)-'0';
        	}
        	idx++;
        	if(dartResult.charAt(idx)=='D') {
        		second = (int) Math.pow(second, 2);
        	}else if(dartResult.charAt(idx)=='T') {
        		second = (int) Math.pow(second, 3);
        	}
        	idx++;
        	if(idx<dartResult.length()) {
	        	if(dartResult.charAt(idx)=='*') {
	        		first*=2;
	        		second*=2;
	        		idx++;
	        	}else if(dartResult.charAt(idx)=='#') {
	        		second=-second;
	        		idx++;
	        	}
        	}
        	answer+=first;
        	//System.out.println(first);
        	first=second;
        }
        
        return answer;
    }
}