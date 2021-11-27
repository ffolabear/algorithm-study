package programmers.level02.cuttingArray;

class CuttingArray_gytj2013 {
    public static int[] solution(int n, long left, long right) {
    	int size = (int) (right-left+1);
    	int[] answer = new int[size];
    	
    	int rL = (int) (left/n);
    	int cL = (int) (left%n);
    	
    	for(int idx =0; idx<size; idx++) {
    		if(cL==n) {cL=0; rL++;}
    		if(cL<rL) {
    			answer[idx]=rL+1;
    		}else {
    			answer[idx]=cL+1;
    		}
    		cL++;
    	}
    	
        return answer;
    }
}