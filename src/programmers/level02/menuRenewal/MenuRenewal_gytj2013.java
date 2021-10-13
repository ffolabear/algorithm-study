package programmers.level02.menuRenewal;

import java.util.*;

class MenuRenewal_gytj2013 {
	HashMap<String, Integer> hashmap = new HashMap<>();
	
    public String[] solution(String[] orders, int[] course) { 

    	for(int customer=0; customer<orders.length; customer++) {
    		String[] arr = orders[customer].split("");
    		Arrays.sort(arr);
    		boolean[] visited = new boolean[arr.length];
    		for(int i=0; i<course.length;i++) {
    			comb(arr, course[i], 0, visited);
    		}
    	}
    	
    	ArrayList<String> answer = new ArrayList<>();
    	
    	for(int i=0; i<course.length;i++) {
			int max=2;
			List<String> listKeySet = new ArrayList<>(hashmap.keySet());
			Collections.sort(listKeySet, (value1, value2) -> (hashmap.get(value2).compareTo(hashmap.get(value1))));
			for(String key : listKeySet) {
				if(key.length()==course[i]) {
					if(max<=hashmap.get(key)) {
						answer.add(key);
						max = hashmap.get(key);
					}
					else {break;}
				}
			}
    	}
    	Collections.sort(answer);
    	
        return answer.toArray(new String[answer.size()]);
    }
    private void comb(String[] arr, int courseNum, int num, boolean[] visited) {
		if(courseNum == 0) {
			String tmp = "";
			for(int i=0; i<arr.length; i++) {
				if(visited[i]) {tmp+=arr[i];}
			}
			if(!hashmap.containsKey(tmp)) {
	    		hashmap.put(tmp, 1);
			}else {hashmap.replace(tmp, hashmap.get(tmp)+1);}
			return;
		}
		if(num == arr.length) {
			return;
		}
		visited[num] = true;
		comb(arr, courseNum-1, num+1, visited);
		visited[num] = false;
		comb(arr, courseNum, num+1, visited);	
	}
}