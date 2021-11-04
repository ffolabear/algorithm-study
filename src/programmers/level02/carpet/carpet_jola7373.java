package carpet;

public class carpet_jola7373 {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        int [] n = solution(brown, yellow);
        System.out.println("answer" + n[0]);
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //우선 yellow를 기준으로 모든 경우의 수를 뽑아 내고 맞는것을 담아준다.
        for(int width =1; width <= yellow/2+1;width++ ){
            int check=0;
            if(yellow % width == 0){
                System.out.println("modulus"+ brown);
                check = search(brown , width, yellow/width);
            }
            if(check != 0){
                answer[0] = (brown+yellow)/check;
                answer[1] = check;
                return answer;
            }
        }
        return answer;
    }
    public static int search(int brown, int width, int height){
        if(brown > 0){//만일 brown 이 0보다 클시 계속 사용
            System.out.println("brown의 값" + brown);
            return search(brown -(2*(width+height)+4), width +2, height+2 );
        }else if(brown <0 ){//0보다 작을시 맞는 계산이 아니라는 뜻이니 return 0로 없음을 표시
            return 0;
        }else{//찾은 것이니 넓이를 리턴
            return width;
        }
    }
}
