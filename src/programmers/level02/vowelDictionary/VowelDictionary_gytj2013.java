package programmers.level02.vowelDictionary;

class VowelDictionary_gytj2013 {
    public static int solution(String word) {
        int answer = 0;
        int[] add = {781,156,31,6,1};
        
        for(int i=0; i<word.length(); i++) {
        	char alpa = word.charAt(i);
        	switch(alpa) {
	            case 'A': answer += 1;
	                 break;
	            case 'E': answer += add[i]+1;
	                 break;
	            case 'I': answer += add[i]*2+1;
	            	break;
	            case 'O': answer += add[i]*3+1;
	            	break;
	            case 'U': answer += add[i]*4+1;
	                 break;
        	}
        }

        return answer;
    }
}