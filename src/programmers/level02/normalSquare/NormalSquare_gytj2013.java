package programmers.level02.normalSquare;

class NormalSquare_gytj2013 {
  public long solution(long w, long h) {
        long big = w>h ? w:h;
        long small = w>h ? h:w;
        
        while(small!=0) {
	        long tmp = small;
	        small = big % small;
	        big = tmp;
        }
        
        return w*h-(w+h-big);
    }
}