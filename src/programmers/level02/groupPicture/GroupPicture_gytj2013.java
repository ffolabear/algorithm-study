package programmers.level02.groupPicture;

class GroupPicture_gytj2013 {
	char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	char[] sequence = new char[8];
	boolean[] visited= new boolean[8];
	int answer = 0;
	
	public int solution(int n, String[] data) {	
        dfs(0, n, data);   
        return answer;
    }
	
	private void dfs(int idx, int n, String[] data) {
		if(idx == 8) {
			if(check(n, data)) {
				answer++;
			}
			return;
		}
		for(int i=0; i<8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				sequence[idx] = friends[i];
				dfs(idx+1, n, data);
				visited[i] = false;
			}			
		}	
	}

	private boolean check(int n, String[] data) {
		for(int i=0; i<n ; i++) {
			int dif = Math.abs(String.valueOf(sequence).indexOf(data[i].charAt(0)) - String.valueOf(sequence).indexOf(data[i].charAt(2)))-1;
			int num = Character.getNumericValue(data[i].charAt(4));
			if(data[i].charAt(3) == '=') {
				if(dif != num) {
					return false;
				}
			}
			else if(data[i].charAt(3) == '>') {if(dif <= num) return false;}
			else if(dif >= num) {return false;}
		}
		return true;
	}
}