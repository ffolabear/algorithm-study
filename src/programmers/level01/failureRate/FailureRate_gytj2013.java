package programmers.level01.failureRate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class FailureRate_gytj2013{
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>(); 
        HashMap<Integer, Double> fail = new HashMap<>(); 
        Integer[] arr = Arrays.stream(stages).boxed().toArray(Integer[]::new);
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        
        for(int i=1; i<N+2; i++) {
        	map.put(i, Collections.frequency(list, i));
        }
        double user = stages.length;
        for(int i=1; i<N+1; i++) {
        	if(user==0) {fail.put(i,(double)0);}
        	else{fail.put(i,map.get(i)/user);}
        	user -= map.get(i);
        }
        ArrayList<Integer> keySetList = new ArrayList<>(fail.keySet());
		Collections.sort(keySetList, (o1, o2) -> (fail.get(o2).compareTo(fail.get(o1))));
		int i=0;
		for(Integer key : keySetList) {
			answer[i]=key;
			i++;
		} 
        return answer;
    }
}