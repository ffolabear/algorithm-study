package programmers.level02.starAtIntersection;

import java.util.ArrayList;
import java.util.Arrays;

class StarAtIntersection_gytj2013 {
	public static class Point{ 
		long x, y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static String[] solution(int[][] line) {
	    ArrayList<Point> list = new ArrayList<>();
	    long len = line.length;
	    long x, y;
	    long arrMaxX=0;
	    long arrMaxY=0;
	    long arrMinX=0;
	    long arrMinY=0;
	    boolean chk=true;
	    
	    for(int i=0; i<len-1; i++) {
	    	for(int j=i+1; j<len; j++) {
	    		long div = (long)line[i][0]*line[j][1]-(long)line[i][1]*line[j][0];
	    		if(div==0) {continue;}
	    		long BFED = (long)line[i][1]*line[j][2]-(long)line[i][2]*line[j][1];
	    		if(BFED%div!=0) {continue;}
	    		x=BFED/div;
	    		long ECAF = (long)line[i][2]*line[j][0]-(long)line[i][0]*line[j][2];
	    		if(ECAF%div!=0) {continue;}
	    		y=ECAF/div;
	    		list.add(new Point(x, y));
	    		if(chk) {
	    			arrMaxX=arrMinX=x;
		    		arrMaxY=arrMinY=y;
		    		chk=false;
	    		}else {
		    		arrMaxX= Math.max(arrMaxX, x);
		    		arrMaxY = Math.max(arrMaxY, y);
		    		arrMinX= Math.min(arrMinX, x);
		    		arrMinY = Math.min(arrMinY, y);
	    		}
	    	}
	    }
	    
	    long sizeX =  Math.abs(arrMaxX-arrMinX)+1;
	    long sizeY = Math.abs(arrMaxY-arrMinY)+1;
	    
	    String[] answer = new String[(int)sizeY];
	  
	    StringBuilder sb= new StringBuilder();
	    for(int i=0; i<sizeX; i++) {
            sb.append(".");
        }
	    Arrays.fill(answer, sb.toString());
	    long nx, ny;
        for(Point p: list){
            ny= arrMaxY-p.y;
            nx= p.x-arrMinX;
            answer[(int)ny]= answer[(int)ny].substring(0, (int)nx)+"*"
                        +answer[(int)ny].substring((int)nx+1);
        }
	 
        
        return answer;
    }
}