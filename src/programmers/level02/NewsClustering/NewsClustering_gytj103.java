package programmers.level02.NewsClustering;

import java.util.ArrayList;
import java.util.List;

class NewsClustering_gytj103 {
    public int solution(String str1, String str2) {
    	str1 = str1.toLowerCase();
    	str2 = str2.toLowerCase();
    	
    	List<String> A = new ArrayList<String>();
    	List<String> B = new ArrayList<String>();
    	
    	for(int i=0; i<str1.length()-1; i++) {
    		if(str1.charAt(i)>=97 & str1.charAt(i)<=122 & str1.charAt(i+1)>=97 & str1.charAt(i+1)<=122) {
    			A.add(str1.substring(i,i+2));
    		}
    	}
    	for(int i=0; i<str2.length()-1; i++) {
    		if(str2.charAt(i)>=97 & str2.charAt(i)<=122 & str2.charAt(i+1)>=97 & str2.charAt(i+1)<=122) {
    			B.add(str2.substring(i,i+2));
    		}
    	}
    	
    	if(A.size()==0 & B.size()==0) {return 65536;}

    	int union = A.size()+B.size();
    	int intersection = 0;
    	
    	for(int i=0; i<A.size(); i++) {
    		if(B.indexOf(A.get(i)) != -1) { 
    			B.remove(A.get(i));
    			intersection++;
    		}
    		
    	}
    	
        return (int)(((double)intersection/(union-intersection))*65536);
    }
}