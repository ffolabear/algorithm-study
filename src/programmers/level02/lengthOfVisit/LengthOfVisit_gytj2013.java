package programmers.level02.lengthOfVisit;
import java.util.*;

class Point {
    int x, y; 
    Character dir;
    Point(int x, int y, char dir) {
         this.x = x;
         this.y = y;
         this.dir=dir;
     }
    @Override
    public int hashCode(){
     return Integer.toString(x).hashCode()+Integer.toString(y).hashCode()+dir.hashCode();
    }
    @Override
	public boolean equals(Object obj) {
		Point p = (Point) obj;
		if(this.x == p.x && this.y == p.y && this.dir == p.dir) {
			return true;
		}
		else {
			return false;
		}
	}
}

class LengthOfVisit_gytj2013 {
    public static int solution(String dirs) {
        Set<Point> set = new HashSet<>();
        int x=0;
        int y=0; 
	    Character dir;
	    Character opp = ' ';
        for(int i=0; i<dirs.length(); i++) {
        	dir = dirs.charAt(i);
        	Point p = new Point(x, y, dir);
        	Boolean chk = false;
        	switch(dir) {
	        	case 'U':
	        		if(y<5) {
	        			y++;
	        			chk=true;
	        			opp = 'D';
	        		}
	        		break;
	        	case 'D':
	        		if(y>-5) {
	        			y--;
	        			chk=true;
	        			opp = 'U';
	        		}
	        		break;
	        	case 'R':
	        		if(x<5) {
	        			x++;
	        			chk=true;
	        			opp = 'L';
	        		}
	        		break;
	        	case 'L':
	        		if(x>-5) {
	        			x--;
	        			chk=true;
	        			opp = 'R';
	        		}
	        		break;
            }
        	if(chk && !set.contains(new Point(x, y, opp))) {set.add(p);}
        }
      
        return set.size();
    }
}