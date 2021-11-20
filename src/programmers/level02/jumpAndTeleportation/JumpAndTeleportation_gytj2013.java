package programmers.level02.jumpAndTeleportation;

public class JumpAndTeleportation_gytj2013 {
    public static int solution(int n) {
        int ans = 1;
       
        while(n>1) {
        	if(n%2==1) {ans++;}
        	n/=2;
        }
        
        return ans;
    }
}