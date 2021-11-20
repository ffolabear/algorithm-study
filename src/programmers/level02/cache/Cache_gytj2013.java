package programmers.level02.cache;

import java.util.*;

class Cache_gytj2013{
    public static int solution(int cacheSize, String[] cities) {
    	LinkedList<String> cache = new LinkedList<>();
    	int answer = 0;
    	 
    	if(cacheSize==0) {return cities.length*5;}
    	
    	for(int i=0; i<cities.length; i++) {
    		String city = cities[i].toLowerCase();
    		if(cache.remove(city)) {
    			cache.addFirst(city);
    			answer++;
    		}else {
    			if(cache.size()==cacheSize) {cache.pollLast();}
    			cache.addFirst(city);
    	    	answer+=5;
    		}
    	}

        return answer;
    }
   
}