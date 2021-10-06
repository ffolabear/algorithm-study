class TargetNumber_gytj2013{
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target);        
        return answer;
    }
    public void dfs(int i, int[] numbers, int target) {
    	if(i == numbers.length) {
    		int sum = 0;
    		for(int number: numbers) {
    			sum += number;
    		}
    		if(sum==target) {answer++;}
    	}
    	else {
    		dfs(i+1, numbers, target);
    		numbers[i] *= -1;
    		dfs(i+1, numbers, target);
    	}
    }
}