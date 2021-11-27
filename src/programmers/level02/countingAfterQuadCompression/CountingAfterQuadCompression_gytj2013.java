package programmers.level02.countingAfterQuadCompression;

class CountingAfterQuadCompression_gytj2013 {
	static int one=0;
	static int zero=0;
    public static int[] solution(int[][] arr) {
    	int size = arr.length;
    	quadtree(arr, 0, 0, size);
    	int[] answer = {zero, one};
        return answer;
    }
    private static void quadtree(int[][] arr, int x, int y, int size) {
    	int chk = check(arr, x, y, size);
		if(chk==1) {one++; return;}
		else if(chk==0) {zero++; return;}
		else {
			size/=2;
			quadtree(arr, x, y, size);
			quadtree(arr, x, y+size, size);
			quadtree(arr, x+size, y, size);
			quadtree(arr, x+size, y+size, size);
		}
		
	}
	private static int check(int[][] arr, int x, int y, int size) {
		int target = arr[x][y];
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(target != arr[i][j]) {return -1;}
			}
		}
		return target;
	}
}