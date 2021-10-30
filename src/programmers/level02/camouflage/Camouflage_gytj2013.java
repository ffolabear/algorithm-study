package programmers.level02.camouflage;
import java.util.*;

class Camouflage_gytj2013 {
	static int answer = 0;
    public static int solution(String[][] clothes) {
    	ArrayList<String> list = new ArrayList<>();
    	for(int i=0; i<clothes.length; i++) {
    		 list.add(clothes[i][1]);
    	}
    	Set<String> set = new HashSet<String>(list);
    	int n = set.size();
    	if(list.size()==n) {
    		return (int) (Math.pow(2, n) - 1);
    	}
    	Integer[] arr = new Integer[n];
    	int i=0;
    	for (String str : set) {
    		arr[i] = Collections.frequency(list, str);
    		i++;
    	}
    	
        for(i=2; i<=n;i++) {
        	comb(arr, 0, n, i, 1);
        }
        answer += clothes.length;
  
        return answer;
    }
    static void comb(Integer[] arr, int start, int n, int r, int calc) {
        if(r == 0) {
        	answer+=calc;
            return;
        }
        for(int i=start; i<n; i++) {
        	calc *= arr[i];
            comb(arr, i + 1, n, r - 1, calc);
            calc /= arr[i];
        }
    }
}