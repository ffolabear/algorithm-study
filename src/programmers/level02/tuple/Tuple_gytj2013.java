package programmers.level02.tuple;

import java.util.HashMap;
import java.util.Iterator;

class Tuple_gytj2013 {
    public int[] solution(String s) {
    	HashMap<Integer, Integer> map = new HashMap();
    	
    	String tmp="";
    	for(int i=0; i<s.length(); i++) {
    		if(s.substring(i,i+1).matches(".*[0-9].*")) {
    			tmp += s.substring(i,i+1);
    		}
    		else if(!tmp.equals("")) {
    			int key = Integer.parseInt(tmp);
    			tmp="";
    			if(map.containsKey(key)) {
    				map.put(key, map.get(key) + 1);
    			}
    			else {map.put(key, 1);}
    		}
    	}
    	
    	int[] answer = new int[map.size()];
    	
    	Iterator<Integer> mapIter = map.keySet().iterator(); 
        while(mapIter.hasNext()){
            Integer key = mapIter.next();
            Integer value = map.get(key);
            
            answer[value-1] = key;
        }
       
        for(int i = 0; i < answer.length/2; i++) {
            int tmp2 = answer[i];
            answer[i] = answer[answer.length-1-i];
            answer[answer.length-i-1] = tmp2;
        }
        
        return answer;
    }
}