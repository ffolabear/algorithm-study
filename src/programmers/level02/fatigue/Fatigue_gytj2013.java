package programmers.level02.fatigue;

class Fatigue_gytj2013{
	static String str =""; 
    public static int solution(int k, int[][] dungeons) {
    	int answer = 0;
    	int dunNum = dungeons.length;
		boolean[] visited = new boolean[dunNum]; 
		
		dfs(visited, dunNum, 0, ""); 
		
		String[] arr = str.split(",");
		
		for(int i=0; i<arr.length; i++) {
			if(answer==dunNum) {break;}
			int ktmp=k;
			int cnt=0;
			for(int j=0; j<dunNum; j++) {
				int tmp = arr[i].charAt(j)-'0';
				if(dungeons[tmp][0] <= ktmp) {
					ktmp-=dungeons[tmp][1];
					cnt++;
				}
				else {break;}
			}
			answer = Math.max(answer, cnt);
		}
		
    	
        return answer;
    }
    static void dfs(boolean[] visited, int n, int len, String tmp) {
    	if(len == n) {
			str+= tmp+",";
			//System.out.println(tmp);
			return;
		}
    	for(int i = 0; i < n; i++) {
    		if(visited[i] != true) {
    			visited[i] = true;
    			tmp+=i;
    			dfs(visited, n, len+1, tmp);    
    			visited[i] = false;
    			tmp=tmp.substring(0, tmp.length()-1);
    		}
    	}
    }
}