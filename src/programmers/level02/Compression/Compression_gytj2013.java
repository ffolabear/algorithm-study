package programmers.level02.Compression;

import java.util.*;

class Compression_gytj2013 {
    public static int[] solution(String msg) {
    	List<String> dic = new ArrayList<>();
    	List<Integer> index = new ArrayList<>();

    	String tmp = "";
    	int idx = 0;
    	Boolean chk = false;
    	for(int i=0; i<msg.length(); i++) {
    		tmp += msg.charAt(i);
    		idx = i+1;
    		while(idx<msg.length()) {
    			tmp += msg.charAt(idx);
    			idx++;
    			if(!dic.contains(tmp)) {chk=true; break;}
    			i++;
    		}
    		if(chk) {
	    		dic.add(tmp);
	    		tmp = tmp.substring(0,tmp.length()-1);
    		}
    		if(tmp.length()==1) {
    			index.add(tmp.charAt(0)-'A'+1);
    		}else {
    			index.add(dic.indexOf(tmp)+27);
    		}
    		tmp="";
    		chk=false;
    	}
    	
        int[] answer = index.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}