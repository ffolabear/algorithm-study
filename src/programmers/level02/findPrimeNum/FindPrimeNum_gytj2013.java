package programmers.level02.findPrimeNum;
import java.util.HashSet;

class FindPrimeNum_gytj2013 {
	static int answer = 0;
	static HashSet<Integer> set = new HashSet<>();
    public static int solution(String numbers) {
    	int n = numbers.length();
    	String arr[] = new String[n];

    	for(int i=0; i<n; i++) {
    		arr[i] = numbers.substring(i,i+1);
    	}
    	for(int i=1; i<n+1; i++) {
    	   boolean[] visited = new boolean[numbers.length()];
    	   String output[] = new String[i];
    	   dfs(arr,output,visited,0,n,i);
    	}

        return answer;
    }
    static void dfs(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {
    	if(depth == r) {
    		int tmp = Integer.parseInt(String.join("", output));
    		if(!set.contains(tmp)) {
    			isPrime(tmp);
    			set.add(tmp);
    		}
    		return;
    	}
    	for(int i = 0; i < n; i++) {
    		if(visited[i] != true) {
    			visited[i] = true;
    			output[depth] = arr[i];
    			dfs(arr, output, visited, depth + 1, n, r);
    			visited[i] = false;
    		}
    	}
    }
    public static void isPrime(int n){
        if(n==0 || n==1) return;
        if(n == 2) {answer++; return;}
        if(n % 2 == 0) return;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return;
        }
        answer++;
        return;
    }
}
