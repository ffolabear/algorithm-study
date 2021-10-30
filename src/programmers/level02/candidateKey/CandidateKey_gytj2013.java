package programmers.level02.candidateKey;
import java.util.*;

class CandidateKey_gytj2013 {
	static Queue<String> queue = new LinkedList<>();
	public static String str = "";
    public static int solution(String[][] relation) {
    	int row = relation.length;
    	int col = relation[0].length;
    	int answer = 0;
    	
    	for(int i=1; i<=col; i++) {
	    	int arr[] = new int[i];
	    	comb(0, 0, arr, col, i);
    	}
    	
    	HashSet<String> set = new HashSet<>();
    	 while(!queue.isEmpty()) {
    		int qSize=queue.size();
    		set.clear();
    		str = "";
    		String check = queue.poll();
    		qSize--;
	    	for(int j=0; j<row; j++) {	
	    		for(int x=0; x<check.length(); x++) {
	    			str += relation[j][check.charAt(x)-'0'];
	    			str+= " ";
	    		}
	    		if(set.contains(str)) {break;}
	    		set.add(str);
	    		str="";
	    	}
	    	if(set.size()==row) {
	    		answer++;
	    		for(int y=0; y<qSize; y++) {
	    			String find = queue.poll();
	    			int cnt=0;
	    			for(int x=0; x<find.length(); x++) {
	    				if(check.contains(find.substring(x,x+1))) {
	    					cnt++;
	    				}
	    			}
	    			if(cnt!=check.length()) {
	    				queue.add(find);
	    			}
	    		}
	    	}
    	}
        return answer;
    }
    static void comb(int L, int start, int[] arr, int n, int r){
        if(L==r){
            for(int a : arr){
                str+=a;
            }
            queue.add(str);
            str="";
            return;
        }
        else{
            for(int i=start;i<n;i++){
                arr[L] = i;
                comb(L+1,i+1,arr, n, r);
            }
        }
	}
}