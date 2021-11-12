package programmers.level02.englishChainGame;

import java.util.HashSet;

class EnglishChainGame_gytj2013 {
    public static int[] solution(int n, String[] words) {
    	HashSet<String> set = new HashSet<String>();
    	int[] answer = {0, 0};
    	
    	set.add(words[0]);
    	char target = words[0].charAt(words[0].length()-1);
    	int i;
    	for(i=1; i< words.length; i++) {
    		if(set.contains(words[i])) {break;}
    		if(target != words[i].charAt(0)) {break;}
    		if(i==words.length-1) {return answer;}
    		set.add(words[i]);
    		target = words[i].charAt(words[i].length()-1);
    	}
        i++;
    	if(i%n==0) {
    		answer[0]=n;
    		answer[1] = i/n;
    	}else {
    		answer[0]=i%n;
    		answer[1] = i/n+1;
    	}
    	
    	
        return answer;
    }
}