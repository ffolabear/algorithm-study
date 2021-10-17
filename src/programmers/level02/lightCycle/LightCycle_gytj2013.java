package programmers.level02.lightCycle;

import java.util.ArrayList;
import java.util.Arrays;

class LightCycle_gytj2013{
	int tmp = 0; 
    public int[] solution(String[] grid) {
    	int R = grid.length;
    	int C = grid[0].length();
    	String[][] arr = new String[R][C];
    	ArrayList<Integer> list = new ArrayList<>();
        boolean[][][] visited = new boolean[R][C][4]; //방문여부 
    	
    	for(int i=0; i<R;i++) {arr[i] = grid[i].split("");}
    	
    	for(int i=0; i<R;i++) {
    		for(int j=i%2; j<C;j+=2) {
    			cycle(arr, visited, i, j, "up");
    	    	if(tmp!=0) {list.add(tmp);tmp=0;}
    	    	cycle(arr, visited, i, j, "right");
    	    	if(tmp!=0) {list.add(tmp);tmp=0;}
    	    	cycle(arr, visited, i, j, "down");
    	    	if(tmp!=0) {list.add(tmp);tmp=0;}
    	    	cycle(arr, visited, i, j, "left");
    	    	if(tmp!=0) {list.add(tmp);tmp=0;}
       		}
    	}
  
        int[] answer = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        
        return answer;
    }
    private void cycle(String[][] arr, boolean[][][] visited, int i, int j, String dir) {
    	while(true) {
	    	if(dir.equals("up")) {
		    	if(arr[i][j].equals("S")) {
					if(visited[i][j][0]) break;
					visited[i][j][0] = true;
					tmp++;
					if(i>0) {i--;}
					else {i=arr.length-1;}
					continue;
				}
				else if(arr[i][j].equals("L")) {
					if(visited[i][j][3]) break;
					visited[i][j][3] = true;
					tmp++;
					dir="left";
					if(j>0) {j--;}
					else {j = arr[0].length-1;}
					continue;
				}
				else {
					if(visited[i][j][1]) break;
					visited[i][j][1] = true;
					tmp++;
					dir="right";
					if(j<arr[i].length-1) {j++;}
					else {j=0;}
					continue;
				}
	    	}
	    	else if(dir.equals("right")) {
		    	if(arr[i][j].equals("L")) {
					if(visited[i][j][0]) break;
					visited[i][j][0] = true;
					tmp++;
					dir="up";
					if(i>0) {i--;}
					else {i = arr.length-1;}
					continue;
				}
				else if(arr[i][j].equals("R")) {
					if(visited[i][j][2]) break;
					visited[i][j][2] = true;
					tmp++;
					dir="down";
					if(i<arr.length-1) {i++;}
					else {i=0;}
					continue;
				}
				else {
					if(visited[i][j][1]) break;
					visited[i][j][1] = true;
					tmp++;
					if(j<arr[i].length-1) {j++;}
					else {j=0;}
					continue;
				}
	    	}
	    	else if(dir.equals("down")) {
		    	if(arr[i][j].equals("R")) {
		    		if(visited[i][j][3]) break;
					visited[i][j][3] = true;
					tmp++;
					dir="left";
					if(j>0) {j--;}
					else {j= arr[i].length-1;}
					continue;
				}
				else if(arr[i][j].equals("S")) {
					if(visited[i][j][2]) break;
					visited[i][j][2] = true;
					tmp++;
					if(i<arr.length-1) {i++;}
					else {i=0;}
					continue;
				}
				else {
					if(visited[i][j][1]) break;
					visited[i][j][1] = true;
					tmp++;
					dir="right";
					if(j<arr[i].length-1) {j++;}
					else {j=0;}
					continue;
				}
	    	}
	     	else {
		    	if(arr[i][j].equals("S")) {
		    		if(visited[i][j][3]) break;
					visited[i][j][3] = true;
					tmp++;
					if(j>0) {j--;}
					else {j = arr[0].length-1;}
					continue;
				}
				else if(arr[i][j].equals("L")) {
					if(visited[i][j][2]) break;
					visited[i][j][2] = true;
					tmp++;
					dir="down";
					if(i<arr.length-1) {i++;}
					else {i=0;}
					continue;
				}
				else {
					if(visited[i][j][0]) break;
					visited[i][j][0] = true;
					tmp++;
					dir="up";
					if(i>0) {i--;}
					else {i=arr.length-1;}
					continue;
				}
	    	}
    	}
	}
}
