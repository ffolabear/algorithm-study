package programmers.level02.sortFile;

import java.util.*;

class File implements Comparable<File> {
	String head;
	int num;
	String file;
    File(String head, int num, String file) {
         this.head = head;
         this.num = num;
         this.file = file;
     }
    @Override
    public int compareTo(File f) {
    	int result = this.head.compareTo(f.head);
    	if(result==0) {
	        result = this.num - f.num;
    	}
    	return result;
    }
}

class SortFile_gytj2013 {
    public static String[] solution(String[] files) {
    	List<File> list = new ArrayList<>();
    	String[] answer = new String[files.length];
    	int num;
    	int idx;
    	int j;
    	int len = files.length;
    	
    	for(int i=0; i<len; i++) {
    		for(idx=0; idx<files[i].length(); idx++) {
    			if(Character.isDigit(files[i].charAt(idx))) {
    				break;
    			}
    		}
    		for(j=idx+1; j<files[i].length(); j++) {
    			if(j==idx+5) {break;}
    			if(!Character.isDigit(files[i].charAt(j))) {
    				break;
    			}
    		}
    		num = Integer.parseInt(files[i].substring(idx, j));
    		list.add(new File(files[i].substring(0, idx).toLowerCase(), num, files[i]));
    	}
    	
    	Collections.sort(list);
    	
    	for(int i=0; i<len; i++) {
    		answer[i] = list.get(i).file;
    	}
    
        return answer;
    }
}